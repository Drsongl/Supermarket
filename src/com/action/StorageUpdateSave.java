package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class StorageUpdateSave extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
	private String Pno ;
    private String Quantity ;

	
	public String getPno() {
		return Pno;
	}
	public void setPno(String pno) {
		Pno = pno;
	}
	public String getQuantity() {
		return Quantity;
	}
	public void setQuantity(String quantity) {
		Quantity = quantity;
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
		if(Integer.parseInt(Quantity)<0){
			out.print("<script language='javascript'>alert('请输入正数的库存量');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		
		
		//�޸�
		
		StorageBean cnbean=new StorageBean();
		cnbean=new StorageDao().GetBean(Integer.parseInt(Pno)); 
		cnbean.setQuantity(Integer.parseInt(Quantity));
		

		new StorageDao().Update(cnbean); // We only change quantity
		    
		//��ת
		out.print("<script language='javascript'>alert('�޸ĳɹ���');window.location='StorageManager.action';</script>");
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
