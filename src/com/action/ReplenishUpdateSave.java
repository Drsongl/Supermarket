package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class ReplenishUpdateSave extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
	private String Ino ;
	private String Proname ;
	private String Pname ;
    private String Vname ;
	private String Lname ;
	private String Grossprice ;
	private String Inum ;
	private String Sno ;
	
	public String getIno() {
		return Ino;
	}
	public void setPno(String ino) {
		Ino = ino;
	}
	public String getProname() {
		return Proname;
	}
	public void setProname(String proname) {
		Proname = proname;
	}
	public String getPname() {
		return Pname;
	}
	public void setPname(String pname) {
		Pname = pname;
	}
	public String getVname() {
		return Vname;
	}
	public void setVname(String vname) {
		Vname = vname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	
	public String getGrossprice() {
		return Grossprice;
	}
	public void setGrossprice(String grossprice) {
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
			out.print("<script language='javascript'>alert('�����µ�¼��');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}
		
		
		
		ReplenishBean cnbean=new ReplenishBean();
		cnbean=new ReplenishDao().GetBean(Integer.parseInt(Ino)); 
		cnbean.setProname(Proname);
		cnbean.setPname(Pname);
		cnbean.setVname(Vname);
		cnbean.setLname(Lname);
		cnbean.setSno(Sno);
		cnbean.setGrossprice(Float.parseFloat(Grossprice));
		cnbean.setInum(Integer.parseInt(Inum));
		
		new ReplenishDao().Update(cnbean);
		    
		//��ת
		out.print("<script language='javascript'>alert('�޸ĳɹ���');window.location='ReplenishWorker.action';</script>");
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
