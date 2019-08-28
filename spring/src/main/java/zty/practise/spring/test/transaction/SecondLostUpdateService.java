package zty.practise.spring.test.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import zty.practise.spring.base.BaseService;
import zty.practise.spring.model.GlobalInfo;

/**
 * 第二类丢失更新：提交覆盖
 * @author zhangtianyi
 *
 */
@Slf4j
@Transactional
@Service("secondLostUpdateService")
public class SecondLostUpdateService extends BaseService<GlobalInfo, Long> {

	/**
	 * 事务1，2 均执行此方法
	 * 更新后提交
	 */
	public void getAndUpdateCommit() {
		System.out.println("开始事务");  
		GlobalInfo info = this.getById(1L);
		System.out.println("查询得到的值为" + info.getEnglishMessage());
		info.setEnglishMessage(info.getEnglishMessage() + "#");  
		this.update(info);
	}                                                              
             
}
