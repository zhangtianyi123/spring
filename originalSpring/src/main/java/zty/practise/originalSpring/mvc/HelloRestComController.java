package zty.practise.originalSpring.mvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestComController {

	@RequestMapping("/com")
	public String com() {
		return "com";
	}
}
