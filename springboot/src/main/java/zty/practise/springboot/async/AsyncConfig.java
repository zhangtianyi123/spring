package zty.practise.springboot.async;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 
 * EnableAsync 注解启用异步处理支持
 * 
 * 可以实现AsyncConfigurer来重写线程池和异常处理器
 * 
 * @author zhangtianyi
 *
 */
@EnableAsync
@Configuration
public class AsyncConfig implements AsyncConfigurer {

	@Override 
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		        
		taskExecutor.setCorePoolSize(5);
		taskExecutor.setMaxPoolSize(10);
		taskExecutor.setQueueCapacity(25);
		taskExecutor.initialize();
		        
		return taskExecutor;
	}
	
	/**
	 * 当不返回值的异步方法发生未捕获异常的时候调用处理
	 */
	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		//可以重写其handleUncaughtException逻辑,默认SimpleAsyncUncaughtExceptionHandler
	    return new MyAsyncUncaughtExceptionHandler();
	}
}
