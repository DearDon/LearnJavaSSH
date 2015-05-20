package whu.don.action;

import whu.don.dao.CustomerDAOImpl;
import whu.don.exception.RegisterException;
import whu.don.service.CustomerServiceImpl;
import whu.don.vo.Customer;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
	private String custname;
	private String pwd;
	private Integer age;
	private String address;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void validate(){
		CustomerDAOImpl dao=new CustomerDAOImpl();
		Customer c=dao.selectByName(custname);
		if(c!=null){
			this.addFieldError("custname",this.getText("custname.exist"));
		}
	}
	public String execute(){
		CustomerServiceImpl cs=new CustomerServiceImpl();
		cs.setDao(new CustomerDAOImpl());
		try {
			cs.register(new Customer(custname,pwd,age,address));
			return "regsuccess";
		} catch (RegisterException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return "regfail";
		}
	}
}
