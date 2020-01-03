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

	//������Action�����ڷ�װ�û��������������
	private String Pno;
	private ProductBean cnbean;
	private List<ProductBean> list1;
	private List<ProductBean> list2;

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
	
	public List<ProductBean> getList1() {
		return list1;
	}
	public void setList1(List<ProductBean> list1) {
		this.list1 = list1;
	}
	public List<ProductBean> getList2() {
		return list2;
	}
	public void setList(List<ProductBean> list2) {
		this.list2 = list2;
	}


	//�����û������execute����
	public String execute() throws Exception {
		
		//������룬����ҳ�����
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		//����session����
		HttpSession session = ServletActionContext.getRequest().getSession();
		//��֤�Ƿ�������¼
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('�����µ�¼��');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}
		
		//��ѯ������Ʒ�������� Vname
		list1=new ProductDao().GetTreeVnameList("","Vno"); // here we want get a list of all product tree vnames
		list2=new ProductDao().GetTreeLnameList("","Lno");
		//��ѯ
		cnbean=new ProductDao().GetBean(Integer.parseInt(Pno)); // we want a bean of particular pno
		return SUCCESS;
		
	}
	
	//�ж��Ƿ��ֵ
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	//����
	public static void main(String[] args) {
		System.out.println();
	}
	
}
