package zty.practise.spring.test.scope;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zty.practise.spring.util.CacheUtils;

@Transactional
@Service("globalizationByRedisService")
public class GlobalizationByRedisService {

	@Value("${base.redis.expireTime}")
	private Long expireTime;
	
	@Autowired
	private CacheUtils cacheUtils;
	
	/**
	 * 从缓存获取国际化描述（使用线程休眠放大竞态条件以测试）
	 * @param key
	 * @return
	 */
	public String getGlobalDescWithWait(String key) {
		if(StringUtils.isEmpty(key)) {
			return null;
		}
		
		String description = (String) cacheUtils.get(key);
		if(description != null) {
			return description;
		}
		
		//测试，放大竞态条件
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		description = getGlobalDescFromDB(key);
		cacheUtils.set(key, description);
		cacheUtils.expire(key, expireTime);
		
		return description;
	}
	
	/**
	 * 从缓存获取国际化描述（存在竞态条件）
	 * @param key
	 * @return
	 */
	public String getGlobalDesc(String key) {
		if(StringUtils.isEmpty(key)) {
			return null;
		}
		
		String description = (String) cacheUtils.get(key);
		if(description != null) {
			return description;
		}
		
		description = getGlobalDescFromDB(key);
		cacheUtils.set(key, description);
		cacheUtils.expire(key, expireTime);
		
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
