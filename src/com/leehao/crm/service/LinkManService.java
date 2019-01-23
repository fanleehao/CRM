package com.leehao.crm.service;

import org.hibernate.criterion.DetachedCriteria;

import com.leehao.crm.domain.LinkMan;
import com.leehao.crm.domain.PageBean;

/** 
 * @author fanleehao
 * @date 创建时间：2019年1月22日 下午9:16:02 
 * @desc 
 **/
public interface LinkManService {

	PageBean<LinkMan> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);

	void save(LinkMan linkMan);

	LinkMan findById(Long lkm_id);

	void update(LinkMan linkMan);

	void delete(LinkMan linkMan);

}
