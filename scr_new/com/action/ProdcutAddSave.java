package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class ProductAddSave extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
	private int Pno ;
    private String Pname ;
    private float Sellprice ;
    private int Vno ;
	private String Vname ;
	private int Lno ;
	private String Lname ;
	private int Shelfno ;


	public int getPno() {
		return Pno;
	}
	public void setPno(int pno) {
		Pno = pno;
	}
	public String getPname() {
		return Pname;
	}
	public void setPname(String pname) {
		Pname = pname;
	}
	public float getSellprice() {
		return Sellprice;
	}
	public void setSellprice(float sellprice) {
		Sellprice = sellprice;
	}	
	public int getVno() {
		return Vno;
	}
	public void setVno(int vno) {
		Vno = vno;
	}
	public String getVname() {
		return Vname;
	}
	public void setVname(String vname) {
		Vname = vname;
	}
	public int getLno() {
		return Lno;
	}
	public void setLno(int lno) {
		Lno = lno;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public int getShelfno() {
		return Shelfno;
	}
	public void setShelfno(int shelfno) {
		Shelfno = shelfno;
	}

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
		
		//��ѯ�Ƿ����
		List<ProductBean> list=new ProductDao().GetList("Pno="+Pno+" and Pname='"+Pname+"'", "");
		if(list.size()>0)
		{
			out.print("<script language='javascript'>alert('����Ʒ��Ż���Ʒ�����Ѵ��ڣ�');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		//���
		ProductBean cnbean=new ProductBean();
		cnbean.setPno(Integer.parseInt(Pno));
		cnbean.setPname(Pname);
		cnbean.setSellprice(Float.parseFloat(Sellprice))
		cnbean.setVno(Integer.parseInt(Vno));
		cnbean.setVname(Vno);
		cnbean.setLno(Integer.parseInt(Lno));
		cnbean.setLname(Lname);
		cnbean.setShelfno(Integer.parseInt(Shelfno));
		new ProductDao().Add(cnbean);
		    
		//��ת
		out.print("<script language='javascript'>alert('��ӳɹ���');window.location='ProductManager.action';</script>");
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
