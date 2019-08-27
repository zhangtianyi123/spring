package zty.practise.spring.base;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseService<T, PK extends Serializable> {

	@Autowired
	protected BaseMapper<T> baseMapper;

	public int save(T entity) {
		return baseMapper.insertSelective(entity);
	}

	public int update(T entity) {
		return baseMapper.updateByPrimaryKey(entity);
	}

	public int updateSelective(T entity) {
		return baseMapper.updateByPrimaryKeySelective(entity);
	}

	public T getById(PK id) {
		return baseMapper.selectByPrimaryKey(id);
	}

	public int deleteById(PK id) {
		return baseMapper.deleteByPrimaryKey(id);
	}
	
}
