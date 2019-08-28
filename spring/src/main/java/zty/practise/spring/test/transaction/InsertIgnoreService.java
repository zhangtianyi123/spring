package zty.practise.spring.test.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import zty.practise.spring.base.BaseService;
import zty.practise.spring.model.GlobalInfo;
import zty.practise.spring.model.GlobalVersionInfo;

@Slf4j
@Transactional
@Service("insertIgnoreService")
public class InsertIgnoreService extends BaseService<GlobalInfo, Long> { 

	public void InsertCommit() {
		System.out.println("开始事务");  
		GlobalInfo info = new GlobalInfo();
		info.setSkey("insertnx");
		int num = this.savenx(info);
		System.out.println("插入操作返回值" + num);
	}    
}
