package com.leehao.crm.dao;

import com.leehao.crm.domain.User;

/** 
 * @author fanleehao
 * @date 创建时间：2019年1月19日 下午3:33:07 
 * @desc 
 **/
public interface UserDao extends BaseDao<User>{
	//void save(User user);

	User login(User user);
}
