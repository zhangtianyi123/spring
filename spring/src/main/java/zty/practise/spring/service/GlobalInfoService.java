package zty.practise.spring.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import zty.practise.spring.base.BaseService;
import zty.practise.spring.dto.GlobalCreateDTO;
import zty.practise.spring.model.GlobalInfo;


@Slf4j
@Transactional
@Service("globalInfoService")
public class GlobalInfoService extends BaseService<GlobalInfo, Long>{

	public void createGlobalInfo(GlobalCreateDTO globalCreateDTO) {
		GlobalInfo globalInfo = new GlobalInfo();
		BeanUtils.copyProperties(globalCreateDTO, globalInfo);
		
		this.save(globalInfo);
		log.info("create new globalinfo : {}", globalInfo);
	}
}
