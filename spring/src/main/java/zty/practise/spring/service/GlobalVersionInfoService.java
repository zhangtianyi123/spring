package zty.practise.spring.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import zty.practise.spring.base.BaseService;
import zty.practise.spring.model.GlobalInfo;
import zty.practise.spring.model.GlobalVersionInfo;

@Slf4j
@Transactional
@Service("globalVersionInfoService")
public class GlobalVersionInfoService extends BaseService<GlobalVersionInfo, Long>{

}
