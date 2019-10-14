package zty.practise.springboot.async;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AsyncController {
	 
	@Autowired
	private UserService userService;
	
	/**
	 * 调用异步方法
	 * 因为需要异步调用的返回值，所以使用Future获取
	 * 
	 * @return
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	@GetMapping("/user/get")
	public String getUserInfo() throws InterruptedException, ExecutionException {
		Future<String> userNameFuture = userService.getUserName();
		
		//异步转同步
		String userName = userNameFuture.get();
		
		log.info("AsyncController#getUserInfo => thread = {}", Thread.currentThread().getName());
		log.info("userName={}", userName);
		return userName;
	}
	
	/**
	 * 调用异步方法
	 * 因为需要异步调用不需要返回值，所以不需要使用Future获取（异步转同步）
	 * 
	 * @return
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	@GetMapping("/user/set")
	public String setUserInfo() throws InterruptedException, ExecutionException {
		log.info("AsyncController#setUserInfo => thread = {}", Thread.currentThread().getName());
		userService.setUserName();
		return "set userName success";
	}
	
}
