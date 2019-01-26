package com.leehao.crm.web.action;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;

import com.leehao.crm.domain.PageBean;
import com.leehao.crm.domain.SaleVisit;
import com.leehao.crm.service.SaleVisitService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/** 
 * @author fanleehao
 * @date 创建时间：2019年1月24日 下午1:27:11 
 * @desc 
 **/
public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit> {


	private SaleVisit saleVisit = new SaleVisit();
	@Override
	public SaleVisit getModel() {
		return saleVisit;
	}
	
	@Resource(name="saleVisitService")
	private SaleVisitService saleVisitService;
	
	//分页参数
	private Integer currPage = 1;
	private Integer pageSize = 3;
	public void setCurrPage(Integer currPage) {
		if(currPage==null){
			currPage = 1;
		}
		this.currPage = currPage;
	}
	public void setPageSize(Integer pageSize) {
		if (pageSize == null) {
			pageSize = 3;
		}
		this.pageSize = pageSize;
	}
	
	//查找所有记录
	public String findAll() {
		//调用业务层，添加条件
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SaleVisit.class);
		//其他条件
		
		//业务
		PageBean<SaleVisit> pageBean = saleVisitService.findByPage(detachedCriteria, currPage, pageSize);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	/**
	 * 保存页面
	 */
	public String saveUI() {
		return "saveUI";
	}
	public String save() {
		saleVisitService.save(saleVisit);
		
		return "saveSuccess";
	}
	
	
	
}
