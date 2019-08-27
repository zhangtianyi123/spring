package zty.practise.spring.test.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("prototype")
public class PrototypeController {

	private int count = 0;
	
	@GetMapping("/test/prototype")
	public Integer send() throws InterruptedException{
		Thread.sleep(5000);
		count++;
		return count;
	}
}
