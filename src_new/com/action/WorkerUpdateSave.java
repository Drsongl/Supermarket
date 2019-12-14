package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class ProductUpdateSave extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
	private String Pno ;
    private String Pname ;
	private String Sellprice ;
	private String Vno ;
    //private String Vname ;
	private String Lno ;
	//private String Lname ;
	private String Shelfno ;
	
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
	/*public String getVname() {
		return Vname;
	}
	public void setVname(String vname) {
		Vname = vname;
	}*/
	public int getLno() {
		return Lno;
	}
	public void setLno(int lno) {
		Lno = lno;
	}
	/*public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}*/
	public int getShelfno() {
		return Shelfno;
	}
	public void setShelfno(int shelfno) {
		Shelfno = shelfno;
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
		
		//��ѯnewname�Ƿ����
		List<ProductBean> list=new ProductDao().GetList("Pname='"+Pname+"' and Pno!="+Pno, "");
		if(list.size()>0)
		{
			out.print("<script language='javascript'>alert('����Ʒ�����Ѵ��ڣ�');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		//�޸�
		
		ProductBean cnbean=new ProductBean();
		cnbean=new ProductDao().GetBean(Integer.parseInt(Pno)); //Pno ���������ķ�ʽ��������ʵ������
		cnbean.setPname(Pname);
		cnbean.setSellprice(Float.parseFloat(Sellprice));
		cnbean.setVno(Integer.parseInt(Vno));
		cnbean.setLno(Integer.parseInt(Lno));
		cnbean.setShelfno(Integer.parseInt(Shelfno));
		cnbean.setStockout_n(Integer.parseInt(Stockout_n));
		new DomitoryDao().Update(cnbean);
		    
		//��ת
		out.print("<script language='javascript'>alert('�޸ĳɹ���');window.location='ProductManager.action';</script>");
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
