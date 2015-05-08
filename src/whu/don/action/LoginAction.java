package whu.don.action;

import whu.don.model.LoginModel;

public class LoginAction {
	private String custname;
	private String pwd;
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String execute(){
		LoginModel ls=new LoginModel();
		boolean flag=ls.login(custname, pwd);
		if(flag){
			return "success";
		}else{
			return "fail";
		}
	}
}
