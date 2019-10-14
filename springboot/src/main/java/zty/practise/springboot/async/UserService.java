package zty.practise.springboot.async;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

	/**
	 * Async标记异步执行方法
	 * 
	 * 异步调用如果需要返回值则需要Future和AsyncResult
	 * 调用方通过Future获取异步调用的返回值
	 */
	@Async
	public Future<String> getUserName() {
		log.info("UserService#getUserName => thread = {}", Thread.currentThread().getName());
		return new AsyncResult<String>("zhangtianyi");
	}
	
	@Async
	public void setUserName() {
		log.info("UserService#setUserName => thread = {}", Thread.currentThread().getName());
		log.info("set userName...");
	}
}
