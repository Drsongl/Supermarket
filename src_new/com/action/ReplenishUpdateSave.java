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

	//下面是Action内用于封装用户请求参数的属性
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
		    
		//跳转
		out.print("<script language='javascript'>alert('修改成功！');window.location='ReplenishWorker.action';</script>");
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
