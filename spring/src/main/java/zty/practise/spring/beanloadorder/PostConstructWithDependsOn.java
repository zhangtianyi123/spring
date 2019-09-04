package zty.practise.spring.beanloadorder;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zty.practise.spring.util.CacheUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;

/**
 * dependsOn将会触发依赖bean的加载过程
 * @author zhangtianyi
 *
 */
@Transactional
@Service
@DependsOn("cacheUtils")
public class PostConstructWithDependsOn {

	/**
	 * 因为有@DependsOn，所以此方法不会导致启动报错
	 */
	@PostConstruct
	public void initialize() {
		System.out.println("PostConstructError's init method");
		CacheUtils.set("初始化数据key", "初始化数据value");
	}
}
