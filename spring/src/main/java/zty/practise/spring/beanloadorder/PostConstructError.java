package zty.practise.spring.beanloadorder;



import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zty.practise.spring.util.CacheUtils;


/**
 * @postconstruct会在加载bean的时候执行，但是bean加载之间有先后关系。如果beanA的@postconstruct内调用beanB的实例，
 * 如果beanB的实例也是在@PostConstruct内初始化的，那么在beanA先于beanB加载的时候，可能发生空指针异常
 * 
 * @author zhangtianyi
 *
 */

@Transactional
@Service
public class PostConstructError {

	/**
	 * 打开注释则服务启动报错，本方法用于展示错误的情况
	 */
//	@PostConstruct
//	public void initialize() {
//		System.out.println("PostConstructError's init method");
//		CacheUtils.set("初始化数据key", "初始化数据value");
//	}
}
