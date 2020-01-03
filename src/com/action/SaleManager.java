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

	//������Action�����ڷ�װ�û��������������
	private List<TrafficBean> list;
	public List<TrafficBean> getList() {
		return list;
	}
	public void setList(List<TrafficBean> list) {
		this.list = list;
	}
	private String SearchRow1;
	private String SearchKey1;
	public String getSearchRow1() {
		return SearchRow1;
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
		String id = (String) session.getAttribute("id");
		if(id ==null){
			out.print("<script language='javascript'>alert('�����µ�¼��');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}
		//��ѯ����
		String strWhere=" 1=1 ";
		String tt = (String) session.getAttribute("type");
		if(tt =="3"){
			
			strWhere+=" and Cno="+id; 
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
		
		
		//��ѯ����
		list=new SaleDao().GetList(strWhere,"Ttime"); 
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
