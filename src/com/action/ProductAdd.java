package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class ProductAdd extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
	private List<ProductBean> list1;
	public List<ProductBean> getList1() {
		return list1;
	}
	public void setList1(List<ProductBean> list1) {
		this.list1 = list1;
	}
	private List<ProductBean> list2;
	public List<ProductBean> getList2() {
		return list2;
	}
	public void setList2(List<ProductBean> list2) {
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
		// �����Ʒ����
		list1=new ProductDao().GetTreeVnameList("","Vno");
		list2=new ProductDao().GetTreeLnameList("","Lno");

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
