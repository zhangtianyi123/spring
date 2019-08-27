package zty.practise.spring.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 通用Mapper接口,其他接口继承该接口即可
 * @param <T> 不能为空
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
