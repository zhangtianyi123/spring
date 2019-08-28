package zty.practise.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zty.practise.spring.dto.GlobalCreateDTO;
import zty.practise.spring.test.transaction.DirtyReadService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	private DirtyReadService dirtyReadService;
	
	@GetMapping("/get")
	public String get() {
		dirtyReadService.testTransactionStarted();
		return "success";
	}
	
	@PostMapping("/uncommit")
	public String updateUnCommmit() {
		dirtyReadService.testReadUnCommmit();
		return "success";
	}
}
