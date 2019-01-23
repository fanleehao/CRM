package com.leehao.crm.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.leehao.crm.dao.LinkManDao;
import com.leehao.crm.domain.LinkMan;

import sun.awt.image.ImageWatched.Link;

/** 
 * @author fanleehao
 * @date 创建时间：2019年1月22日 下午9:15:30 
 * @desc 
 **/
public class LinkManDaoImpl extends BaseDaoImpl<LinkMan> implements LinkManDao {

	public LinkManDaoImpl() {
		super(LinkMan.class);
	}	
	
}
