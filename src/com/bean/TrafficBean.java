package com.bean;

import java.util.Date;

public class TrafficBean {

	private int Tno ;
	private Date Ttime ;
	private int Gno ;
	private String Pname ;
	private String Vname  ;
	private String Lname ;
	private int Cno ;
	private int Sno ;

	
	public int getTno() {
		return Tno;
	}
	public void setTno(int tno) {
		Tno = tno;
	}
	public Date getTtime() {
		return Ttime;
	}
	public void setTtime(Date ttime) {
		Ttime = ttime;
	}
	public int getGno() {
		return Gno;
	}
	public void setGno(int gno) {
		Gno = gno;
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
	public String getPname() {
		return Pname;
	}
	public void setPname(String pname) {
		Pname = pname;
	}
	public int getCno() {
		return Cno;
	}
	public void setCno(int cno) {
		Cno = cno;
	}	
	public int getSno() {
		return Sno;
	}
	public void setSno(int sno) {
		Sno = sno;
	}	
}
