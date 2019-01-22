package com.leehao.crm.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.leehao.crm.domain.Customer;

/** 
 * @author fanleehao
 * @date 创建时间：2019年1月20日 下午3:20:41 
 * @desc 
 **/
public interface CustomerDao {

	void save(Customer customer);

	Integer findCount(DetachedCriteria detachedCriteria);

	List<Customer> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize);

	void delete(Customer customer);

	Customer findById(Long cust_id);

	void update(Customer customer);

}
