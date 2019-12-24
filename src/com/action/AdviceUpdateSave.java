package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class AdviceUpdateSave extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
	private String Ono ;
	private String Offtime ;
	private String Sno ;
	private String Ostatus ;

	
	public String getOno() {
		return Pno;
	}
	public void setOno(String ono) {
		Ono = ono;
	}
	public String getOfftime() {
		return Pno;
	}
	public void setOfftime(String offtime) {
		Offtime = offtime;
	}
	public String getSno() {
		return Sno;
	}
	public void setSno(String sno) {
		Sno = sno;
	}
	public String getOstatus() {
		return Pno;
	}
	public void setOstatus(String ostatus) {
		Ostatus = ostatus;
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
		
		
		//�޸�
		
		AdviceBean cnbean=new AdviceBean();
		cnbean=new AdviceDao().GetBean(Integer.parseInt(Ono)); 
		cnbean.setOfftime(Offtime);
		cnbean.setSno(Sno);
		cnbean.setOstatus(Ostatus);

		new AdviceDao().Update(cnbean); // We only change quantity
		    
		//��ת
		out.print("<script language='javascript'>alert('�޸ĳɹ���');window.location='AdviceManager.action';</script>");
		out.flush();out.close();return null;
		
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
