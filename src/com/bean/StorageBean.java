package com.bean;
public class StorageBean {

    private int Pno ;
	private String Pname ;
	private int Quantity;
	private int Stockout_n;
	
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
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public int getStockout_n() {
		return Stockout_n;
	}
	public void setStockout_n(int stockout_n) {
		Stockout_n = stockout_n;
	}
}
