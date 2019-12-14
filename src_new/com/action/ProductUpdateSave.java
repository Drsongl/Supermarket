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

	//下面是Action内用于封装用户请求参数的属性
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
		
		//查询newname是否存在
		List<ProductBean> list=new ProductDao().GetList("Pname='"+Pname+"' and Pno!="+Pno, "");
		if(list.size()>0)
		{
			out.print("<script language='javascript'>alert('该商品名称已存在！');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		//修改
		
		ProductBean cnbean=new ProductBean();
		cnbean=new ProductDao().GetBean(Integer.parseInt(Pno)); //Pno 采用自增的方式，不具有实际意义
		cnbean.setPname(Pname);
		cnbean.setSellprice(Float.parseFloat(Sellprice));
		cnbean.setVno(Integer.parseInt(Vno));
		cnbean.setLno(Integer.parseInt(Lno));
		cnbean.setShelfno(Integer.parseInt(Shelfno));
		cnbean.setStockout_n(Integer.parseInt(Stockout_n));
		new DomitoryDao().Update(cnbean);
		    
		//跳转
		out.print("<script language='javascript'>alert('修改成功！');window.location='ProductManager.action';</script>");
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
