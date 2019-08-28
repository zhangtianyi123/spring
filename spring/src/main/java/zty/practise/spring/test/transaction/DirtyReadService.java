package zty.practise.spring.test.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import zty.practise.spring.base.BaseService;
import zty.practise.spring.model.GlobalInfo;

@Slf4j
@Transactional
@Service("dirtyReadService")
public class DirtyReadService extends BaseService<GlobalInfo, Long> {

	/**
	 * 无锁读
	 * 证明事务开启
	 */
	public void testTransactionStarted() {
		GlobalInfo info = this.getById(1L);
		
		System.out.println("英文描述是" + info.getEnglishMessage());
	}
	
	/** 
	 * 更新操作
	 * 和testTransactionStarted 配合验证脏读（读未提交）
	 */
	public void testReadUnCommmit() {
		GlobalInfo info = this.getById(1L);
		info.setEnglishMessage("dirtyData");
		this.update(info);
	}
}
