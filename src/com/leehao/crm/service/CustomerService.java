package com.leehao.crm.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.leehao.crm.domain.Customer;
import com.leehao.crm.domain.PageBean;

/** 
 * @author fanleehao
 * @date 创建时间：2019年1月20日 下午3:21:40 
 * @desc 
 **/
public interface CustomerService {

	void save(Customer customer);

	PageBean<Customer> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);

	Customer findById(Long cust_id);

	void delete(Customer customer);

	void update(Customer customer);

	List<Customer> findAll();

}
