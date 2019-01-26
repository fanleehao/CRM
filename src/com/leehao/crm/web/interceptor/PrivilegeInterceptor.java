package com.leehao.crm.web.interceptor;

import org.apache.struts2.ServletActionContext;

import com.leehao.crm.domain.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/** 
 * @author fanleehao
 * @date 创建时间：2019年1月26日 下午1:01:57 
 * @desc 
 **/
public class PrivilegeInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// 控制权限登录
		User loginUser = (User) ServletActionContext.getContext().getSession().get("loginUser");
		if(loginUser == null){
			//给出错误
			ActionSupport actionSupport = (ActionSupport) invocation.getAction();
			actionSupport.addActionError("没有权限，请登录！");
			return actionSupport.LOGIN;
		}
		else{
			return invocation.invoke();
		}
	}

}
