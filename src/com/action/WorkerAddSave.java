package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class WorkerAddSave extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
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
		List<WorkerBean> list=new WorkerDao().GetList("Sno="+Sno, "");
		if(list.size()>0)
		{
			out.print("<script language='javascript'>alert('该学号已被注册');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		
		if(Integer.parseInt(Sgrade)>4)
		{
			out.print("<script language='javascript'>alert('请输入合适的年级（1-4）');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		//���
		WorkerBean cnbean=new WorkerBean();
		cnbean.setSno(Integer.parseInt(Sno));
		cnbean.setSname(Sname);
		cnbean.setSgrade(Integer.parseInt(Sgrade));
		cnbean.setSjob(Sjob);

		new WorkerDao().Add(cnbean);
		    
		//��ת
		out.print("<script language='javascript'>alert('员工添加成功！');window.location='WorkerManager.action';</script>");
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
