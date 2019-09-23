package zty.practise.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloBootController {
	
	@GetMapping("/hello")
	public String hello() {
		return "springBoot!!!";
	}
}
