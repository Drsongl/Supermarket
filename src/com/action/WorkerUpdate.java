package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class WorkerUpdate extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
	private String Sno;
	private WorkerBean cnbean;

	public String getSno() {
		return Sno;
	}

	public void setSno(String sno) {
		Sno = sno;
	}

	public WorkerBean getCnbean() {
		return cnbean;
	}

	public void setCnbean(WorkerBean cnbean) {
		this.cnbean = cnbean;
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
			out.print("<script language='javascript'>alert('请登录账号');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}
		
		
		//��ѯ
		cnbean=new WorkerDao().GetBean(Integer.parseInt(Sno)); // we want a bean of particular sno
		
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
