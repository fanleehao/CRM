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
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {

	
	public CustomerDaoImpl() {
		super(Customer.class);
	}

//	@Override
//	public Integer findCount(DetachedCriteria detachedCriteria) {
//		// select count(*) from xxx where 条件;
//		detachedCriteria.setProjection(Projections.rowCount());
//		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
//		if (list.size() > 0) {
//			return list.get(0).intValue();
//		}
//
//		return null;
//	}

	

}
