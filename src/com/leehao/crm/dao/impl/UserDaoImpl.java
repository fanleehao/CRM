package com.leehao.crm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.leehao.crm.dao.UserDao;
import com.leehao.crm.domain.User;

/** 
 * @author fanleehao
 * @date 创建时间：2019年1月19日 下午3:33:52 
 * @desc 
 **/
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

//	@Override
//	public void save(User user) {
//		this.getHibernateTemplate().save(user);
//		System.out.println("Dao regist....");
//	}

	public UserDaoImpl() {
		super(User.class);
	}

	@Override
	public User login(User user) {
		// 查询
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where user_code = ? and user_password = ?", 
				user.getUser_code(), user.getUser_password());
		if (list.size() > 0) {
			return list.get(0);
		}
		else {
			return null;
		}
		
	}

}
