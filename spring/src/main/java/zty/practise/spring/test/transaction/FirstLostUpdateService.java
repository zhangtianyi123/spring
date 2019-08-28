package zty.practise.spring.test.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import zty.practise.spring.base.BaseService;
import zty.practise.spring.model.GlobalInfo;

/**
 * 第一类丢失更新：回滚覆盖
 * @author zhangtianyi
 *
 */
@Slf4j
@Transactional
@Service("firstLostUpdateService")
public class FirstLostUpdateService extends BaseService<GlobalInfo, Long> {

	/**
	 * 更新后提交
	 */
	public void getAndUpdateCommit() {
		System.out.println("开始事务");  
		GlobalInfo info = this.getById(1L);
		info.setEnglishMessage("commitData");  
		this.update(info);
	}                                                              //2

	/**
	 * 更新后回滚
	 */
	public void getAndUpdateRollBack() {
		System.out.println("开始事务");                             
		GlobalInfo info = this.getById(1L);                         //1
		info.setEnglishMessage("rollbackData");
		this.update(info);
		
		//异常触发回滚
		int error = 3/0;
	}                                                                //3
	
}
