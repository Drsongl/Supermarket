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
	private Stirng Pno ;
    private String Pname ;
    private String Sellprice ;
    private String Vno ;
	private String Vname ;
	private String Lno ;
	private String Lname ;
	private String Shelfno ;


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
	public String getVname() {
		return Vname;
	}
	public void setVname(String vname) {
		Vname = vname;
	}
	public String getLno() {
		return Lno;
	}
	public void setLno(String lno) {
		Lno = lno;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public String getShelfno() {
		return Shelfno;
	}
	public void setShelfno(String shelfno) {
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
		List<ProductBean> list=new ProductDao().GetList("Pname='"+Pname+"'", "");
		if(list.size()>0)
		{
			out.print("<script language='javascript'>alert('该商品名称已存在！');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		//查询货架编号是否存在
		List<ShelfBean> list=new ProductDao().GetShelfList("Shelfno="+Shelfno, "");
		if(list.size()==0)
		{
			out.print("<script language='javascript'>alert('该货架不存在！');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		if(Integer.parseInt(Stockout_n)<0 )
		{
			out.print("<script language='javascript'>alert('请输入正的商品最低库存量！');history.back(-1);</script>");
			out.flush();out.close();return null;
		}

		//添加
		ProductBean cnbean=new ProductBean();
		
		cnbean.setPname(Pname);
		cnbean.setSellprice(Float.parseFloat(Sellprice))
		cnbean.setVno(Integer.parseInt(Vno));
		cnbean.setLno(Integer.parseInt(Lno));
		cnbean.setShelfno(Integer.parseInt(Shelfno));
		cnbean.setStockout_n(Integer.parseInt(Stockout_n));

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
