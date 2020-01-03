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
	private String Stockout_n ;
	
	public String getPno() {
		return Pno;
	}
	public void setPno(String pno) {
		Pno = pno;
	}
	public String getPname() {
		return Pname;
	}
	public void setPname(String pname) {
		Pname = pname;
	}
	public String getSellprice() {
		return Sellprice;
	}
	public void setSellprice(String sellprice) {
		Sellprice = sellprice;
	}	
	public String getVno() {
		return Vno;
	}
	public void setVno(String vno) {
		Vno = vno;
	}
	/*public String getVname() {
		return Vname;
	}
	public void setVname(String vname) {
		Vname = vname;
	}*/
	public String getLno() {
		return Lno;
	}
	public void setLno(String lno) {
		Lno = lno;
	}
	/*public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}*/
	public String getShelfno() {
		return Shelfno;
	}
	public void setShelfno(String shelfno) {
		Shelfno = shelfno;
	}
	public String getStockout_n() {
		return Stockout_n;
	}
	public void setStockout_n(String stockout_n) {
		Stockout_n = stockout_n;
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
		
		//��ѯnewname�Ƿ����
		List<ProductBean> list=new ProductDao().GetList("Pname='"+Pname+"' and Pno!="+Pno, "");
		if(list.size()>0)
		{
			out.print("<script language='javascript'>alert('该商品名称已被其他商品使用');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		//�޸�
		List<ShelfBean> list1=new ProductDao().GetShelfList("Shelfno="+Shelfno, "");
		if(list1.size()==0)
		{
			out.print("<script language='javascript'>alert('请输入已存在的货架编号');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		if(Integer.parseInt(Stockout_n)<0 )
		{
			out.print("<script language='javascript'>alert('请输入正数的商品最低库存量');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		
		ProductBean cnbean=new ProductBean();
		cnbean=new ProductDao().GetBean(Integer.parseInt(Pno)); //Pno ���������ķ�ʽ��������ʵ������
		cnbean.setPname(Pname);
		cnbean.setSellprice(Float.parseFloat(Sellprice));
		cnbean.setVno(Integer.parseInt(Vno));
		cnbean.setLno(Integer.parseInt(Lno));
		cnbean.setShelfno(Integer.parseInt(Shelfno));
		cnbean.setStockout_n(Integer.parseInt(Stockout_n));
		new ProductDao().Update(cnbean);
		    
		//��ת
		out.print("<script language='javascript'>alert('修改成功！');window.location='ProductManager.action';</script>");
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
