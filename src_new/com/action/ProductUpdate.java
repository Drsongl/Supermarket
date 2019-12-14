package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class ProductUpdate extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	private String Pno;
	private ProductBean cnbean;
	private List<ProducttreeBean> list;

	public String getPno() {
		return Pno;
	}

	public void setPno(String pno) {
		Pno = pno;
	}

	public ProductBean getCnbean() {
		return cnbean;
	}

	public void setCnbean(ProductBean cnbean) {
		this.cnbean = cnbean;
	}
	
	public List<ProducttreeBean> getList() {
		return list;
	}
	public void setList(List<ProducttreeBean> list) {
		this.list = list;
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
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}
		
		//查询所有商品大类名称 Vname
		list=new ProducttreeDao().GetList("","Vname"); // here we want get a list of all product tree vnames
		//查询
		cnbean=new ProductDao().GetBean(Integer.parseInt(Pno)); // we want a bean of particular pno
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
