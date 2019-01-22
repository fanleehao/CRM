package com.leehao.crm.domain;

import java.util.List;

/** 
 * @author fanleehao
 * @date 创建时间：2019年1月20日 下午7:59:47 
 * @desc Page模型
 **/
public class PageBean<T> {
	private Integer currPage;	// 当前页数
	private Integer pageSize;	// 每页显示记录数
	private Integer totalCount; // 总记录数
	private Integer totalPage; // 总页数
	private List<T> list; // 每页查询到的数据的集合
	public Integer getCurrPage() {
		return currPage;
	}
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
}
