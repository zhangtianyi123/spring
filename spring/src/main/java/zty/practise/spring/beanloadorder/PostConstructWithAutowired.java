package zty.practise.spring.beanloadorder;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zty.practise.spring.util.CacheUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * autowired将会触发引用bean的加载过程，相当于dependsOn
 * @author zhangtianyi
 *
 */
@Transactional
@Service
public class PostConstructWithAutowired {

	@Autowired
	private CacheUtils cacheUtils;
	
	/**
	 * 因为有@Autowired，所以此方法不会导致启动报错
	 */
	@PostConstruct
	public void initialize() {
		System.out.println("PostConstructError's init method");
		CacheUtils.set("初始化数据key", "初始化数据value");
	}
}
