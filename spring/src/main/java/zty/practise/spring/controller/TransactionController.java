package zty.practise.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zty.practise.spring.dto.GlobalCreateDTO;
import zty.practise.spring.test.transaction.DeleteOptimisticLockService;
import zty.practise.spring.test.transaction.DirtyReadService;
import zty.practise.spring.test.transaction.FirstLostUpdateService;
import zty.practise.spring.test.transaction.InsertIgnoreService;
import zty.practise.spring.test.transaction.OptimisticLockService;
import zty.practise.spring.test.transaction.PhantomReadService;
import zty.practise.spring.test.transaction.ReadCommitService;
import zty.practise.spring.test.transaction.SecondLostUpdateService;

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
	
	@Autowired
	private SecondLostUpdateService secondLostUpdateService;
	
	@Autowired
	private OptimisticLockService optimisticLockService;
	
	@Autowired
	private DeleteOptimisticLockService deleteOptimisticLockService;
	
	@Autowired
	private InsertIgnoreService insertIgnoreService;
	
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
	
	@PostMapping("/second/get/update")
	public String secondGetAndUpdate() {
		secondLostUpdateService.getAndUpdateCommit();
		return "success";
	}
	
	@PostMapping("/second/update")
	public String secondUpdate() {
		secondLostUpdateService.getAndUpdateCommit();
		return "success";
	}
	
	@PostMapping("/optimistic/get/update")
	public String optimisticGetAndUpdate() {
		optimisticLockService.getAndUpdateCommit();
		return "success";
	}
	
	@PostMapping("/optimistic/update")
	public String optimisticUpdate() {
		optimisticLockService.getAndUpdateCommit();
		return "success";
	}
	
	@PostMapping("/optimistic/get/delete")
	public String optimisticGetAndDelete() {
		deleteOptimisticLockService.getAndDeleteCommit();
		return "success";
	}
	
	@PostMapping("/optimistic/delete")
	public String optimisticDelete() {
		deleteOptimisticLockService.getAndDeleteCommit();
		return "success";
	}
	
	@PostMapping("/insertnx")
	public String insertnx() {
		insertIgnoreService.InsertCommit();
		return "success";
	}
	
}
