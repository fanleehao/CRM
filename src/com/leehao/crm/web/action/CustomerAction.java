package com.leehao.crm.web.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.leehao.crm.domain.Customer;
import com.leehao.crm.domain.PageBean;
import com.leehao.crm.service.CustomerService;
import com.leehao.crm.utils.UploadUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/** 
 * @author fanleehao
 * @date 创建时间：2019年1月20日 下午3:23:17 
 * @desc 
 **/
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	//模型驱动，封装
	private Customer customer = new Customer();
	@Override
	public Customer getModel() {
		return customer;
	}

	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	//使用属性驱动，给分页查询参数注入值
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
	/**
	 * 文件上传相关的3个参数
	 */
	private String uploadFileName;
	private File upload;
	private String uploadContentType;
	
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	
	
	
	
	
	/**
	 * SaveUI
	 */
	public String saveUI() {
		return "saveUI";
	}
	/**
	 * Save
	 * @throws IOException 
	 */
	public String save() throws IOException {
		//添加上传文件操作
		if (upload != null) {
			//获得路径和随机文件名，保存到指定路径下
			String filename = UploadUtils.getRandomFileName(uploadFileName);
			String floder = UploadUtils.getRandomFloderName(uploadFileName);
			String path = "d:/upload" + floder;
			//创建对应的目录
			File realPath = new File(path);
			if (!realPath.exists()) {
				//不存在则创建
				realPath.mkdirs();
			}
			//创建保存文件
			File realFile = new File(path + "/" + filename);
			FileUtils.copyFile(upload, realFile);
			//将文件路径保存到customer中
			customer.setCust_image(path + "/" + filename);
			
		}
		customerService.save(customer);		
		return "saveSuccess";
	}
	/**
	 * findAll：分页的全部客户查询
	 */
	public String findAll() {
		//使用离线的criteria的查询
		//分页参数和数量
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
		//业务层查询
		//添加筛选——条件查询Web层设置
		if (customer.getCust_name() != null && !"".equals(customer.getCust_name())) {
			//按名称
			detachedCriteria.add(Restrictions.like("cust_name", "%"+ customer.getCust_name() +"%"));
		}
		if (customer.getCust_source() != null && !"".equals(customer.getCust_source())) {
			Long dict_id = customer.getCust_source().getDict_id();
			if(dict_id != null && !"".equals(dict_id)){
				detachedCriteria.add(Restrictions.eq("cust_source.dict_id", dict_id));
			}
		}
		if (customer.getCust_level() != null && !"".equals(customer.getCust_level())) {
			Long dict_id = customer.getCust_level().getDict_id();
			if(dict_id != null && !"".equals(dict_id)){
				detachedCriteria.add(Restrictions.eq("cust_level.dict_id", dict_id));
			}
		}
		if (customer.getCust_industry() != null && !"".equals(customer.getCust_industry())) {
			Long dict_id = customer.getCust_industry().getDict_id();
			if(dict_id != null && !"".equals(dict_id)){
				detachedCriteria.add(Restrictions.eq("cust_industry.dict_id", dict_id));
			}
		}
		PageBean<Customer> pageBean = customerService.findByPage(detachedCriteria, currPage, pageSize);
		//存入值栈，返回跳转
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	/**
	 * 删除客户
	 */
	public String delete() {
		//删除关联文件
		Customer cusToDelete = customerService.findById(customer.getCust_id());
		String fileToDelete = cusToDelete.getCust_image();
		if(fileToDelete != null && !"".equals(fileToDelete)){
			//删除文件
			File file = new File(fileToDelete);
//			System.out.println("file----" + file);
			if (file.exists()) {
//				System.out.println("文件存在！");
				file.delete();
			}
		}
		customerService.delete(cusToDelete);		
		return "deleteSuccess";
	}
	
	/**
	 * 修改客户信息回显
	 */
	public String edit() {
		//查询客户
		customer = customerService.findById(customer.getCust_id());
		//修改客户数据的信息，将信息回传至页面___-页面可以直接从model里获得
		//ActionContext.getContext().getValueStack().push(customer);
		return "editSuccess";
	}
	/**
	 * 客户信息更新
	 * @throws IOException 
	 */
	public String update() throws IOException {
		//注意图片是否重新编辑
		if (upload != null) {
			//重新上传了文件
			String filePath = customer.getCust_image();
			//删除原先的文件
			if(filePath != null && !"".equals(filePath)){
				File fileToDelete = new File(filePath);
				if(fileToDelete.exists()){
					fileToDelete.delete();
				}
			}
			//重新上传
			String filename = UploadUtils.getRandomFileName(uploadFileName);
			String floder = UploadUtils.getRandomFloderName(uploadFileName);
			String path = "d:/upload" + floder;
			//创建对应的目录
			File realPath = new File(path);
			if (!realPath.exists()) {
				//不存在则创建
				realPath.mkdirs();
			}
			//创建保存文件
			File realFile = new File(path + "/" + filename);
			FileUtils.copyFile(upload, realFile);
			//将文件路径保存到customer中
			customer.setCust_image(path + "/" + filename);
		}
		
		customerService.update(customer);		
		return "updateSuccess";
	}
}
