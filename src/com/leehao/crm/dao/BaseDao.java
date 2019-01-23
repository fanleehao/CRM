package com.leehao.crm.dao;
/** 
 * @author fanleehao
 * @date 创建时间：2019年1月23日 下午7:41:00 
 * @desc 
 **/
public interface BaseDao<T> {
	void save(T t);
	void delete(T t);
	void update(T t);
}
