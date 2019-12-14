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

	//������Action�����ڷ�װ�û��������������
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
		List<ProductBean> list=new WorkerDao().GetList("Sno="+Sno+"", "");
		if(list.size()>0)
		{
			out.print("<script language='javascript'>alert('��Ա��ѧ���Ѵ��ڣ�');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		//���
		ProductBean cnbean=new WorkerBean();
		cnbean.setSno(Integer.parseInt(Sno));
		cnbean.setSname(Sname);
		cnbean.setSgrade(Float.parseFloat(Sgrade))
		cnbean.setSjob(Sjob);

		new ProductDao().Add(cnbean);
		    
		//��ת
		out.print("<script language='javascript'>alert('��ӳɹ���');window.location='WorkerManager.action';</script>");
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
