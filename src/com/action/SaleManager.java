package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class SaleManager extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	private List<ReplenishBean> list;
	public List<ReplenishBean> getList() {
		return list;
	}
	public void setList(List<ReplenishBean> list) {
		this.list = list;
	}
	private String SearchRow1;
	private String SearchKey1;
	public String getSearchRow1() {
		return SearchRow;
	}
	public void setSearchRow(String searchRow1) {
		SearchRow1 = searchRow1;
	}
	public String getSearchKey1() {
		return SearchKey1;
	}
	public void setSearchKey1(String searchKey1) {
		SearchKey1 = searchKey1;
	}

	private String SearchRow2;
	private String SearchKey2;
	public String getSearchRow2() {
		return SearchRow2;
	}
	public void setSearchRow2(String searchRow2) {
		SearchRow2 = searchRow2;
	}
	public String getSearchKey2() {
		return SearchKey2;
	}
	public void setSearchKey2(String searchKey2) {
		SearchKey2 = searchKey2;
	}

	//处理用户请求的execute方法
	public String execute() throws Exception {
		
		//解决乱码，用于页面输出
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		//创建session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		//验证是否正常登录
		String id = new session.getAttribute("id")
		if(id ==null){
			out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}
		//查询条件
		String strWhere="1=1";

		if(session.getAttribute("type")=='3'){
			
			strwhere+=" and Cno="+id; 
			if(!(isInvalid(SearchKey1)))
			{
				strWhere+=" and "+SearchRow1+"='"+SearchKey1+"'";
			}
			if(!(isInvalid(SearchKey2)))
			{
				strWhere+=" and "+SearchRow2+"='"+SearchKey2+"'";
			}
			
		}

		else{
			if(!(isInvalid(SearchKey1)))
			{
				strWhere+=" and "+SearchRow1+"='"+SearchKey1+"'";
			}
			if(!(isInvalid(SearchKey2)))
			{
				strWhere+=" and "+SearchRow2+"='"+SearchKey2+"'";
			}
			
		}
		
		
		//查询所有
		list=new SaleDao().GetList(strWhere,"Ttime"); // here we need 三张表的join，销售表，商品信息表（获得商品名称），商品树表（获得商品大类小类的名称）
	
		return SUCCESS;
		
	}
	
	//判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	//测试
	public static void main(String[] args) {
		System.out.println();
	}
	
}
