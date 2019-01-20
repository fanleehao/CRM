package com.leehao.crm.service;

import com.leehao.crm.domain.User;

/** 
 * @author fanleehao
 * @date 创建时间：2019年1月19日 下午3:30:40 
 * @desc 
 **/
public interface UserService {
	void regist(User user);

	User login(User user);
}
