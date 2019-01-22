package com.leehao.crm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.leehao.crm.dao.BaseDictDao;
import com.leehao.crm.domain.BaseDict;

/** 
 * @author fanleehao
 * @date 创建时间：2019年1月20日 下午5:03:43 
 * @desc 
 **/
public class BaseDictDaoImpl extends HibernateDaoSupport implements BaseDictDao {

	@Override
	public List<BaseDict> findByTypeCode(String dict_type_code) {
		return (List<BaseDict>) this.getHibernateTemplate().find("from BaseDict where dict_type_code=?", dict_type_code);		
	}
	
}
