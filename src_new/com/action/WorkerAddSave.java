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
	private Stirng Sno ;
    private String Sname ;
    private String Sgrade ;
    private String Sjob ;



	public String getSno() {
		return Sno;
	}
	public void setSno(int sno) {
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
		List<ProductBean> list=new WorkerDao().GetList("Sno="+Sno+"", "");
		if(list.size()>0)
		{
			out.print("<script language='javascript'>alert('该员工学号已存在！');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		//添加
		ProductBean cnbean=new WorkerBean();
		cnbean.setSno(Integer.parseInt(Sno));
		cnbean.setSname(Sname);
		cnbean.setSgrade(Float.parseFloat(Sgrade))
		cnbean.setSjob(Sjob);

		new ProductDao().Add(cnbean);
		    
		//跳转
		out.print("<script language='javascript'>alert('添加成功！');window.location='WorkerManager.action';</script>");
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
