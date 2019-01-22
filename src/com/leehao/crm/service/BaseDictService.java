package com.leehao.crm.service;

import java.util.List;

import com.leehao.crm.domain.BaseDict;

/** 
 * @author fanleehao
 * @date 创建时间：2019年1月20日 下午5:04:18 
 * @desc 
 **/
public interface BaseDictService {

	List<BaseDict> findByTypeCode(String dict_type_code);

}
