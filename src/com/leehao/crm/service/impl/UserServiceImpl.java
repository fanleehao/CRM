package com.leehao.crm.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.leehao.crm.dao.UserDao;
import com.leehao.crm.domain.User;
import com.leehao.crm.service.UserService;
import com.leehao.crm.utils.MD5Utils;

/** 
 * @author fanleehao
 * @date 创建时间：2019年1月19日 下午3:31:34 
 * @desc 
 **/

@Transactional
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}	
	
	@Override
	public void regist(User user) {
		//对业务数据，进行加密		
		System.out.println("Service Regist....");
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		user.setUser_state("1");   //表示用户正常使用
		
		userDao.save(user);
	}

	@Override
	public User login(User user) {
		//加密
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		return userDao.login(user);
	}

}
