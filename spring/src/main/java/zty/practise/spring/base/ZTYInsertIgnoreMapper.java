package zty.practise.spring.base;

import org.apache.ibatis.annotations.InsertProvider;

import tk.mybatis.mapper.annotation.RegisterMapper;

@RegisterMapper
public interface ZTYInsertIgnoreMapper<T> {

    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     *
     * @param record
     * @return
     */
    @InsertProvider(type = ZTYBaseInsertProvider.class, method = "dynamicSQL")
    int insertIgnore(T record);

}