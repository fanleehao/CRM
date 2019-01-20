package com.leehao.crm.web.action;

import org.apache.struts2.ServletActionContext;

import com.leehao.crm.domain.User;
import com.leehao.crm.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/** 
 * @author fanleehao
 * @date 创建时间：2019年1月19日 下午3:25:10 
 * @desc 
 **/
public class UserAction extends ActionSupport implements ModelDriven<User> {

	private User user = new User();
	@Override
	public User getModel() {
		return user;
	}
	
	//注入Service 
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * 注册用户
	 * @return
	 */
	public String regist() {
		System.out.println("Action  Regist.....");
		userService.regist(user);		
		return LOGIN;
	}
	
	/**
	 * 登录控制
	 */
	public String login(){
		User loginUser = userService.login(user);
		if(loginUser == null){
			//登录失败
			this.addActionError("用户名或密码错误！");
			return LOGIN;
		}
		else {
			//成功，存入session
//			ServletActionContext.getRequest().getSession().setAttribute("loginUser", loginUser);
			ActionContext.getContext().getSession().put("loginUser", loginUser);
			return SUCCESS;
		}
	}
	
}


