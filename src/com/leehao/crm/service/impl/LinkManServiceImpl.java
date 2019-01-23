package com.leehao.crm.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.leehao.crm.dao.LinkManDao;
import com.leehao.crm.domain.LinkMan;
import com.leehao.crm.domain.PageBean;
import com.leehao.crm.service.LinkManService;

/** 
 * @author fanleehao
 * @date 创建时间：2019年1月22日 下午9:16:18 
 * @desc 
 **/

@Transactional
public class LinkManServiceImpl implements LinkManService {
	private LinkManDao linkManDao;
	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}
	@Override
	public PageBean<LinkMan> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize) {
		//封装Bean
		PageBean<LinkMan> pageBean = new PageBean<>();
		pageBean.setCurrPage(currPage);
		pageBean.setPageSize(pageSize);
		Integer totalCount = linkManDao.findCount(detachedCriteria);
		pageBean.setTotalCount(totalCount);
		//页数
		Double tc = totalCount.doubleValue();
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		
		//每页的集合
		Integer begin = (currPage - 1) * pageSize;
		//System.out.println(pageBean);
		List<LinkMan> list = linkManDao.findByPage(detachedCriteria, begin, pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}
	@Override
	public void save(LinkMan linkMan) {
		linkManDao.save(linkMan);
	}
	
	@Override
	public LinkMan findById(Long lkm_id) {
		return linkManDao.findById(lkm_id);
	}
	@Override
	public void update(LinkMan linkMan) {
		linkManDao.update(linkMan);
	}
	@Override
	public void delete(LinkMan linkMan) {
		linkManDao.delete(linkMan);
	}
	
	
}
