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


public class ProductAddSave extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	private String Ino ;
    private String Prono ;
    private String Pno ;
	private String Inum ;
    private String Grossprice ;
	private String Sno ;
	private String Idata ;

	public String getIno() {
		return Username;
	}
	public void setIno(String ino) {
		Ino = ino;
	}
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
	public void setSno(String Sno) {
		Sno = sno;
	}
	public String getIdate() {
		return Idate;
	}
	public void setIdate(String idate) {
		Idate = idate;
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
		
		
		//添加
		ReplenishBean cnbean=new ReplenishBean();
		cnbean.setProno(Integer.parseInt(Prono));
		cnbean.setPno(Integer.parseInt(Pno));
		cnbean.setIno(Integer.parseInt(Ino));
		cnbean.setGrossprice(Float.parseFloat(Grossprice))
		cnbean.setSno(Sno);
		cnbean.setIdate(Idate);

		new ReplenishDao().Add(cnbean);
		    
		//跳转
		out.print("<script language='javascript'>alert('添加成功！');window.location='ReplenishManager.action';</script>");
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
