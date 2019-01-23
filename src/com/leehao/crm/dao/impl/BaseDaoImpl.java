package com.leehao.crm.dao.impl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.leehao.crm.dao.BaseDao;

/** 
 * @author fanleehao
 * @date 创建时间：2019年1月23日 下午7:43:58 
 * @desc 
 **/
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	@Override
	public void save(T t) {
		this.getHibernateTemplate().save(t);		
	}

	@Override
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

}
