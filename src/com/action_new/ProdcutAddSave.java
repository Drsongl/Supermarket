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

	//下面是Action内用于封装用户请求参数的属性
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

	//处理用户请求的execute方法
	public String execute() throws Exception {
		
		//解决乱码，用于页面输出
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		//创建session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		//验证是否正常登录
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}
		
		//查询是否存在
		List<ProductBean> list=new ProductDao().GetList("Pno="+Pno+" and Pname='"+Pname+"'", "");
		if(list.size()>0)
		{
			out.print("<script language='javascript'>alert('该商品编号或商品名称已存在！');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		//添加
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
		    
		//跳转
		out.print("<script language='javascript'>alert('添加成功！');window.location='ProductManager.action';</script>");
		out.flush();out.close();return null;
		
	}
	
	//判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	//测试
	public static void main(String[] args) {
		System.out.println();
	}
	
}
