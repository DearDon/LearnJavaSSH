package whu.don.action;


import whu.don.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String custname;
	private String pwd;
	private CustomerService service;
	
	public void setService(CustomerService service) {
		this.service = service;
	}
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
	
	public void validate(){
		/*
		CustomerDAOHibImpl dao=new CustomerDAOHibImpl();
		Customer c=dao.selectByName(custname);
		if(c==null){
			this.addFieldError("custname", this.getText("custname.notexist"));
		}
			
		*/
		boolean flag=service.testName(custname);
		if(!flag){
			this.addFieldError("custname", this.getText("custname.notexist"));
		}
		/*else{
			this.addFieldError("custname", this.getText("custname.notexist"));
		}
		*/
	}
	public String execute(){
		/*
		CustomerServiceImpl cs=new CustomerServiceImpl();
		cs.setDao(new CustomerDAOHibImpl());
		
		boolean flag=cs.login(custname, pwd);
		if(flag){
			return "success";
		}else{
			//this.addActionMessage(this.getText("Your password or account is wrong, try again!"));
			this.addActionError(this.getText("pwd.wrong"));
			return "fail";
		}
		*/
		boolean flag=service.login(custname, pwd);
		if(flag){
			return "success";
		}else{
			this.addActionError(this.getText("pwd.wrong"));
			return "fail";
		}
	}
}
