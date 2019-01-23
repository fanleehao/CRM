package com.leehao.crm.dao;

import java.util.List;

import com.leehao.crm.domain.BaseDict;

/** 
 * @author fanleehao
 * @date 创建时间：2019年1月20日 下午5:03:20 
 * @desc 
 **/
public interface BaseDictDao extends BaseDao<BaseDict>{

	List<BaseDict> findByTypeCode(String dict_type_code);

}
