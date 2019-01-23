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

	@Override
	public Integer findByCount(DetachedCriteria detachedCriteria) {
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		if (list.size() > 0) {
			return list.get(0).intValue();
		}
		return null;
	}

	@Override
	public List<LinkMan> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize) {
		detachedCriteria.setProjection(null);
		
		List<LinkMan> list = (List<LinkMan>) this.getHibernateTemplate().findByCriteria(detachedCriteria, begin, pageSize);
	
//		for (LinkMan linkMan : list) {
//			System.out.println(linkMan);
//		}		
		return list;
	}

	
	@Override
	public LinkMan findById(Long lkm_id) {
		return this.getHibernateTemplate().get(LinkMan.class, lkm_id);
	}
	
}
