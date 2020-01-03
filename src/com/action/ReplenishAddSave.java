package com.action;

import java.io.PrintWriter;
import java.util.List;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class ReplenishAddSave extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
    private String Prono ;
    private String Pno ;
	private String Inum ;
    private String Grossprice ;
	private String Sno ;

	public String getProno() {
		return Prono;
	}
	public void setProno(String prono) {
		Prono = prono;
	}
	public String getPno() {
		return Pno;
	}
	public void setPno(String pno) {
		Pno = pno;
	}	
	public String getInum() {
		return Inum;
	}
	public void setInum(String inum) {
		Inum = inum;
	}	
	public String getGrossprice() {
		return Grossprice;
	}
	public void setGrossprice(String grossprice ) {
		Grossprice = grossprice;
	}
	public String getSno() {
		return Sno;
	}
	public void setSno(String sno) {
		Sno = sno;
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
		
		
		//���
		ReplenishBean cnbean=new ReplenishBean();
		cnbean.setProno(Integer.parseInt(Prono));
		cnbean.setPno(Integer.parseInt(Pno));
		cnbean.setGrossprice(Float.parseFloat(Grossprice));
		cnbean.setSno(Integer.parseInt(Sno));
		cnbean.setPno(Integer.parseInt(Inum));

		new ReplenishDao().Add(cnbean);
		    
		//��ת
		out.print("<script language='javascript'>alert('成功添加供货记录');window.location='ReplenishManager.action';</script>");
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
