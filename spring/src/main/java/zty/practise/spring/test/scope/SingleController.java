package zty.practise.spring.test.scope;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SingleController {

	private int count = 0;
	
	@GetMapping("/test/single")
	public Integer send() throws InterruptedException{
		Thread.sleep(5000);
		count++;
		return count;
	}
}
