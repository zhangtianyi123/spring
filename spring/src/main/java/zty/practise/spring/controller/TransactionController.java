package zty.practise.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zty.practise.spring.dto.GlobalCreateDTO;
import zty.practise.spring.test.transaction.DirtyReadService;
import zty.practise.spring.test.transaction.FirstLostUpdateService;
import zty.practise.spring.test.transaction.PhantomReadService;
import zty.practise.spring.test.transaction.ReadCommitService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	private DirtyReadService dirtyReadService;
	
	@Autowired
	private ReadCommitService readCommitService;
	
	@Autowired
	private PhantomReadService phantomReadService;
	
	@Autowired
	private FirstLostUpdateService firstLostUpdateService;
	
	@GetMapping("/get")
	public String get() {
		dirtyReadService.testTransactionStarted();
		return "success";
	}
	
	@PostMapping("/update")
	public String updateUnCommmit() {
		dirtyReadService.testReadUnCommmit();
		return "success";
	}
	
	@PostMapping("/repeateread")
	public String repeateRead() {
		readCommitService.testRepeatRead();
		return "success";
	}
	
	@PostMapping("/insert")
	public String insert() {
		phantomReadService.testInsert();
		return "success";
	}
	
	@PostMapping("/readtable")
	public String readTable() {
		phantomReadService.testRepeatReadTable();
		return "success";
	}
	
	@PostMapping("/first/commmit")
	public String firstCommit() {
		firstLostUpdateService.getAndUpdateCommit();
		return "success";
	}
	
	@PostMapping("/first/rollback")
	public String firstRollBack() {
		firstLostUpdateService.getAndUpdateRollBack();
		return "success";
	}
	
}
