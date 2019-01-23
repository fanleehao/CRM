package com.leehao.crm.web.action;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.leehao.crm.domain.Customer;
import com.leehao.crm.domain.LinkMan;
import com.leehao.crm.domain.PageBean;
import com.leehao.crm.service.CustomerService;
import com.leehao.crm.service.LinkManService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/** 
 * @author fanleehao
 * @date 创建时间：2019年1月22日 下午9:17:11 
 * @desc 
 **/
public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {
	
	private LinkMan linkMan = new LinkMan();
	@Override
	public LinkMan getModel() {
		return linkMan;
	}
	
	private LinkManService linkManService;
	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	
	//注入分页
	private Integer currPage = 1;
	private Integer pageSize = 3;
	public void setCurrPage(Integer currPage) {
		if(currPage == null){
			currPage = 1;
		}
		this.currPage = currPage;
	}
	public void setPageSize(Integer pageSize) {
		if(pageSize == null){
			pageSize = 3;
		}
		this.pageSize = pageSize;
	}

	
	//查询所有
	public String findAll(){
		//封装Bean
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LinkMan.class);
		//带条件的查询
		if(linkMan.getLkm_name() != null && ! "".equals(linkMan.getLkm_name())){
			detachedCriteria.add(Restrictions.like("lkm_name", "%" + linkMan.getLkm_name() + "%"));
		}
		if(linkMan.getLkm_gender() != null && !"".equals(linkMan.getLkm_gender())){
			detachedCriteria.add(Restrictions.eq("lkm_gender", linkMan.getLkm_gender()));
		}
		
		
		PageBean<LinkMan> pageBean = linkManService.findByPage(detachedCriteria, currPage, pageSize);
		ActionContext.getContext().getValueStack().push(pageBean);		
		return "findAll";
	}
	
	/**
	 * 新增操作
	 */
	public String saveUI() {
		//先查询初所有的客户
		List<Customer> list = customerService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
	}
	public String save() {
		linkManService.save(linkMan);
		
		return "saveSuccess";
	}
	
	/**
	 * 编辑
	 */
	public String edit() {
		//先查询初所有的客户,方便回显
		List<Customer> list = customerService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		
		linkMan = linkManService.findById(linkMan.getLkm_id());
		ActionContext.getContext().getValueStack().push(linkMan);
		return "editSuccess";
	}
	
	/**
	 * 更新
	 */
	public String update() {
		linkManService.update(linkMan);		
		return "updateSuccess";
	}
	
	/**
	 * 删除
	 */
	public String delete() {
		linkMan = linkManService.findById(linkMan.getLkm_id());
		linkManService.delete(linkMan);
		return "deleteSuccess";
	}
	
}





