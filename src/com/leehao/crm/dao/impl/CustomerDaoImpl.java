package com.leehao.crm.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.leehao.crm.dao.CustomerDao;
import com.leehao.crm.domain.Customer;

/**
 * @author fanleehao
 * @date 创建时间：2019年1月20日 下午3:21:05
 * @desc
 **/
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	@Override
	public void save(Customer customer) {
		this.getHibernateTemplate().save(customer);
	}

	@Override
	public Integer findCount(DetachedCriteria detachedCriteria) {
		// select count(*) from xxx where 条件;
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		if (list.size() > 0) {
			return list.get(0).intValue();
		}

		return null;
	}

	@Override
	public List<Customer> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize) {
		//清空count(*)的条件
		detachedCriteria.setProjection(null);
		return (List<Customer>) this.getHibernateTemplate().findByCriteria(detachedCriteria, begin, pageSize);
	}

	@Override
	public void delete(Customer customer) {
		this.getHibernateTemplate().delete(customer);
	}

	@Override
	public Customer findById(Long cust_id) {
		return this.getHibernateTemplate().get(Customer.class, cust_id);
	}

	@Override
	public void update(Customer customer) {
		this.getHibernateTemplate().update(customer);
	}

}
