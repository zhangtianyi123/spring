package zty.practise.spring.test.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import zty.practise.spring.base.BaseService;
import zty.practise.spring.model.GlobalVersionInfo;

@Slf4j
@Transactional
@Service("deleteOptimisticLockService")
public class DeleteOptimisticLockService extends BaseService<GlobalVersionInfo, Long>{

	/**
	 * 事务1，2 均执行此方法
	 * 更新后提交
	 */
	public void getAndDeleteCommit() {
		System.out.println("开始事务");  
		GlobalVersionInfo info = this.getById(1L);
		System.out.println("查询得到的值为" + info.getEnglishMessage());
		info.setEnglishMessage(info.getEnglishMessage() + "#");  
		int num = this.deleteById(1L);
		System.out.println("删除操作返回值" + num);
	}      
}
