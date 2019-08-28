package zty.practise.spring.dao;

import org.apache.ibatis.annotations.Mapper;

import zty.practise.spring.base.BaseMapper;
import zty.practise.spring.model.GlobalInfo;
import zty.practise.spring.model.GlobalVersionInfo;

@Mapper
public interface GlobalVersionInfoMapper extends BaseMapper<GlobalVersionInfo> {

}
