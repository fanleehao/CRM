package com.leehao.crm.service;

import org.hibernate.criterion.DetachedCriteria;

import com.leehao.crm.domain.PageBean;
import com.leehao.crm.domain.SaleVisit;

/** 
 * @author fanleehao
 * @date 创建时间：2019年1月24日 下午1:23:37 
 * @desc 
 **/
public interface SaleVisitService {

	PageBean<SaleVisit> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);

	void save(SaleVisit saleVisit);
	
}
