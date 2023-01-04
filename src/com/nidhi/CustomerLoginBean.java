package com.nidhi;

public class CustomerLoginBean {
	private String uname,pwd;
	public CustomerLoginBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CustomerLoginBean(String uname, String pwd) {
		super();
		this.uname = uname;
		this.pwd=pwd;
	}
	public String getuname() {
		return uname;
	}
	public void setuname(String uname) {
		this.uname = uname;
	}
	
	public String getpwd() {
		return pwd;
	}
	public void setpwd(String pwd) {
		this.pwd = pwd;
	}
}
