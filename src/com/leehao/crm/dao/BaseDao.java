package com.leehao.crm.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

/** 
 * @author fanleehao
 * @date 创建时间：2019年1月23日 下午7:41:00 
 * @desc 
 **/
public interface BaseDao<T> {
	void save(T t);
	
	void delete(T t);
	
	void update(T t);

	T findById(Serializable id);

	List<T> findAll();

	Integer findCount(DetachedCriteria detachedCriteria);

	List<T> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize);
	
}
