package com.leehao.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.leehao.crm.dao.SaleVisitDao;
import com.leehao.crm.domain.PageBean;
import com.leehao.crm.domain.SaleVisit;
import com.leehao.crm.service.SaleVisitService;

/** 
 * @author fanleehao
 * @date 创建时间：2019年1月24日 下午1:25:00 
 * @desc 
 **/

@Transactional
public class SaleVisitServiceImpl implements SaleVisitService {
	@Resource(name="saleVisitDao")
	private SaleVisitDao saleVisitDao;

	@Override
	public PageBean<SaleVisit> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize) {
		//封装pageBean
		PageBean<SaleVisit> pageBean = new PageBean<>();
		pageBean.setCurrPage(currPage);
		pageBean.setPageSize(pageSize);
		//总记录数
		Integer totalCount = saleVisitDao.findCount(detachedCriteria);
		pageBean.setTotalCount(totalCount);
		
		//Double tc = totalCount.doubleValue();
		Double totalPage = Math.ceil(totalCount.doubleValue() / pageSize);
		pageBean.setTotalPage(totalPage.intValue());
		
		Integer begin = (currPage - 1) * pageSize;
		List<SaleVisit> list = saleVisitDao.findByPage(detachedCriteria, begin, pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}

	@Override
	public void save(SaleVisit saleVisit) {
		saleVisitDao.save(saleVisit);
	}
	
}
