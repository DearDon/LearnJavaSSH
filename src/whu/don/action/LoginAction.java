package whu.don.action;

import whu.don.dao.CustomerDAOImpl;
import whu.don.service.CustomerServiceImpl;

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
		CustomerServiceImpl cs=new CustomerServiceImpl();
		cs.setDao(new CustomerDAOImpl());
		
		boolean flag=cs.login(custname, pwd);
		if(flag){
			return "success";
		}else{
			return "fail";
		}
	}
}
