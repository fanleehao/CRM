package com.leehao.crm.web.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.leehao.crm.domain.BaseDict;
import com.leehao.crm.service.BaseDictService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

/** 
 * @author fanleehao
 * @date 创建时间：2019年1月20日 下午5:06:11 
 * @desc 
 **/
public class BaseDictAction extends ActionSupport implements ModelDriven<BaseDict> {

	
	private BaseDict baseDict = new BaseDict();
	@Override
	public BaseDict getModel() {
		return baseDict;
	}
	
	private BaseDictService baseDictService;
	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}
	
	/**
	 * 查询字典的Action
	 * @throws IOException 
	 */
	public String findByTypeCode() throws IOException{
		//调用service，查询不同类型的字典值
//		Map<String, Object> parameters = ActionContext.getContext().getParameters();
		
		List<BaseDict> list =  baseDictService.findByTypeCode(baseDict.getDict_type_code());
		//将结果写成JSon格式
		JsonConfig config = new JsonConfig();
		//去除多余的字段
		config.setExcludes(new String[]{"dict_code","dict_memo","dict_enable"});
		JSONArray jsonArray = JSONArray.fromObject(list, config);
		//System.out.println(list);
		//返回给页面		
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(jsonArray);
		
		return NONE;
	}
	
	
}
