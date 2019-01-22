package com.leehao.crm.service.impl;

import java.util.List;

import com.leehao.crm.dao.BaseDictDao;
import com.leehao.crm.service.BaseDictService;
import com.leehao.crm.domain.BaseDict;

/** 
 * @author fanleehao
 * @date 创建时间：2019年1月20日 下午5:04:42 
 * @desc 
 **/
public class BaseDictServiceImpl implements BaseDictService {
	private BaseDictDao baseDictDao;
	public void setBaseDictDao(BaseDictDao baseDictDao) {
		this.baseDictDao = baseDictDao;
	}
	@Override
	public List<BaseDict> findByTypeCode(String dict_type_code) {
		return baseDictDao.findByTypeCode(dict_type_code);
	}
	
}
