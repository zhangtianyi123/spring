package zty.practise.originalSpring.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class HelloRestJsonController {

	@Autowired
	private HelloService helloService;
	
	@RequestMapping("/json")
	public LotInfo json() throws JsonProcessingException {
		return helloService.getLotInfo();
	}
}
