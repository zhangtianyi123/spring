package zty.practise.spring.test.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import zty.practise.spring.base.BaseService;
import zty.practise.spring.model.GlobalInfo;
import zty.practise.spring.model.GlobalVersionInfo;

/**
 * (数据库)乐观锁避免第二类丢失更新：提交覆盖
 * @author zhangtianyi
 *
 */
@Slf4j
@Transactional
@Service("optimisticLockService")
public class OptimisticLockService extends BaseService<GlobalVersionInfo, Long>{

	/**
	 * 事务1，2 均执行此方法
	 * 更新后提交
	 */
	public void getAndUpdateCommit() {
		System.out.println("开始事务");  
		GlobalVersionInfo info = this.getById(1L);
		System.out.println("查询得到的值为" + info.getEnglishMessage());
		info.setEnglishMessage(info.getEnglishMessage() + "#");  
		int num = this.update(info);
		System.out.println("更新操作返回值" + num);
	}            
}
