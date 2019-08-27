package zty.practise.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zty.practise.spring.dto.GlobalCreateDTO;
import zty.practise.spring.service.GlobalInfoService;

@RestController
@RequestMapping("/global")
public class GlobalInfoController {
	
	@Autowired
	private GlobalInfoService globalInfoService;

	@PostMapping("/create")
	public String create(@RequestBody GlobalCreateDTO globalCreateDTO) {
		globalInfoService.createGlobalInfo(globalCreateDTO);
		return "success";
	}
}
