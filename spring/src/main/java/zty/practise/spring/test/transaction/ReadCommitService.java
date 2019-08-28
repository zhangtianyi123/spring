package zty.practise.spring.test.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import zty.practise.spring.base.BaseService;
import zty.practise.spring.model.GlobalInfo;

@Slf4j
@Transactional
@Service("readCommitService")
public class ReadCommitService extends BaseService<GlobalInfo, Long> {

	/**
	 * 两次无锁读
	 * 证明可重复读
	 */
	public void testRepeatRead() {
		GlobalInfo info = this.getById(1L);
		System.out.println("第一次英文描述是" + info.getEnglishMessage());
		
		
		GlobalInfo info2 = this.getById(1L);
		System.out.println("第二次英文描述是" + info2.getEnglishMessage());
		System.out.println("第一次和第二次读在同一个事务中理应相同");
	}
}
