package zty.practise.spring.test.scope;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import zty.practise.spring.util.CacheUtils;

@Transactional
@Service("globalizationByRedisService")
public class GlobalizationByRedisService {

	@Value("${base.redis.expireTime}")
	private Long expireTime;

	/**
	 * 从缓存获取国际化描述（使用线程休眠放大竞态条件以测试）
	 * 
	 * @param key
	 * @return
	 */
	public String getGlobalDescWithWait(String key) {
		if (StringUtils.isEmpty(key)) {
			return null;
		}

		String description = (String) CacheUtils.get(key);
		if (description != null) {
			return description;
		}

		// 测试，放大竞态条件
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		description = getGlobalDescFromDB(key);
		CacheUtils.set(key, description);
		CacheUtils.expire(key, expireTime);

		return description;
	}

	/**
	 * 从缓存获取国际化描述（存在竞态条件）
	 * 
	 * @param key
	 * @return
	 */
	public String getGlobalDesc(String key) {
		if (StringUtils.isEmpty(key)) {
			return null;
		}

		String description = (String) CacheUtils.get(key);
		if (description != null) {
			return description;
		}

		description = getGlobalDescFromDB(key);
		CacheUtils.set(key, description);
		CacheUtils.expire(key, expireTime);

		return description;
	}

	final ReadWriteLock rwLock = new ReentrantReadWriteLock();
	final Lock readLock = rwLock.readLock();
	final Lock writeLock = rwLock.writeLock();

	/**
	 * 从缓存获取国际化描述（高并发版本）
	 * 
	 * @param key
	 * @return
	 */
	public String getGlobalDescSync(String key) {
		if (StringUtils.isEmpty(key)) {
			return null;
		}

		String description = null;
		readLock.lock();
		try {
			description = (String) CacheUtils.get(key);
		} finally {
			readLock.unlock();
		}

		if (description != null) {
			return description;
		}

		writeLock.lock();
		try {
			//高并发情况下为了节省DBConnecition 在临界区内二次验证
			description = (String) CacheUtils.get(key);
			if(description == null) {
				description = getGlobalDescFromDB(key);
				CacheUtils.set(key, description);
				CacheUtils.expire(key, expireTime);
			}
		} finally {
			writeLock.unlock();
		}
		return description;
	}

	/**
	 * 模拟从DB返回持久层数据
	 */
	private String getGlobalDescFromDB(String key) {
		System.out.println(Thread.currentThread() + "执行DB查询");
		return key + "'s  value";
	}
}
