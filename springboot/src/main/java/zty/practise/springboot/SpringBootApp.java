package zty.practise.springboot;

import java.util.concurrent.ExecutionException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zty.practise.springboot.async.AsyncController;
import zty.practise.springboot.util.SpringContextHolder;

@SpringBootApplication
public class SpringBootApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApp.class, args);
		
		AsyncController asyncController = SpringContextHolder.getBean("asyncController");
		try {
			asyncController.getUserInfo();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
