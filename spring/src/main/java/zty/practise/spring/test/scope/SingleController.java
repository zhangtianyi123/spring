package zty.practise.spring.test.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SingleController {

	private int count = 0;
	
	@Autowired
	private  GlobalizationByRedisService globalizationByRedisService;
	
	@GetMapping("/test/single")
	public Integer count() throws InterruptedException{
		Thread.sleep(5000);
		count++;
		return count;
	}
	
	@GetMapping("/desc/get")
	public String getDescription() {
		return globalizationByRedisService.getGlobalDesc("key");
	}
	
	@GetMapping("/desc/getwait")
	public String getDescriptionWait() {
		return globalizationByRedisService.getGlobalDescWithWait("key");
	}
}
