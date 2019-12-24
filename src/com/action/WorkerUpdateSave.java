package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class WorkerUpdateSave extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	private String Sno ;
    private String Sname ;
	private String Sgrade ;
	private String Sjob ;
	
	public String getSno() {
		return Sno;
	}
	public void setSno(String sno) {
		Sno = sno;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public String getSgrade() {
		return Sgrade;
	}
	public void setSgrade(String sgrade) {
		Sgrade = sgrade;
	}	
	public String getSjob() {
		return Sjob;
	}
	public void setSjob(String sjob) {
		Sjob = sjob;
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
		
		
		//修改
		
		WorkerBean cnbean=new WorkerBean();
		cnbean=new WorkerDao().GetBean(Integer.parseInt(Sno)); 
		cnbean.setSname(Sname);
		cnbean.setSgrade(Sgrade);
		cnbean.setSjob(Sjob);

		new WorkerDao().Update(cnbean);
		    
		//跳转
		out.print("<script language='javascript'>alert('修改成功！');window.location='WorkerManager.action';</script>");
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
