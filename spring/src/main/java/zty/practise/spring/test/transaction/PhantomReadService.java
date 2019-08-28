package zty.practise.spring.test.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import zty.practise.spring.base.BaseService;
import zty.practise.spring.dao.GlobalInfoMapper;
import zty.practise.spring.model.GlobalInfo;

/**
 * 测试幻读的service
 * @author zhangtianyi
 *
 */
@Slf4j
@Transactional
@Service("phantomReadService")
public class PhantomReadService  extends BaseService<GlobalInfo, Long>  {


	@Autowired
	private GlobalInfoMapper globalInfoMapper;
	
	/**
	 * 两次无锁（表范围）读
	 * 证明可重复读
	 */
	public void testRepeatReadTable() {
		List<GlobalInfo> infos = globalInfoMapper.selectAll();
		System.out.println("第一次size是" + infos.size());
		
		
		List<GlobalInfo> infos2 = globalInfoMapper.selectAll();
		System.out.println("第二次size是" + infos2.size());
		System.out.println("第一次和第二次读在同一个事务中理应相同");
	}
	
	/**
	 * 插入动作
	 */
	public void testInsert() {
		GlobalInfo info = new GlobalInfo();
		info.setSkey("key002");
		info.setEnglishMessage("insertData");
		this.save(info);
	}
}
