package whu.don.action;


import whu.don.exception.RegisterException;
import whu.don.service.CustomerService;
import whu.don.vo.Customer;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RegisterAction extends ActionSupport implements ModelDriven<Customer> {
	/*
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
	*/
	private Customer cust=new Customer();
	private CustomerService service;
	
	public void setService(CustomerService service) {
		this.service = service;
	}
	public Customer getModel() {
		// TODO Auto-generated method stub
		return cust;
	}
	public void validate(){
		/*
		CustomerDAOHibImpl dao=new CustomerDAOHibImpl();
		Customer c=dao.selectByName(custname);
		if(c!=null){
			this.addFieldError("custname",this.getText("custname.exist"));
		}
		*/
		boolean flag=service.testName(cust.getCustname());
		if(flag){
			this.addFieldError("custname",this.getText("custname.exist"));
		}
	}
	public String execute(){
		/*
		CustomerServiceImpl cs=new CustomerServiceImpl();
		cs.setDao(new CustomerDAOHibImpl());
		try {
			cs.register(new Customer(custname,pwd,age,address));
			return "regsuccess";
		} catch (RegisterException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return "regfail";
		}
		*/
		try {
			service.register(cust);
//			this.addActionMessage("Register successfully,login pls.");
			//this.addActionMessage(this.getText("register.successful"));
			return "regsuccess";
		} catch (RegisterException e) {
			// TODO Auto-generated catch block
//			this.addActionError("Sorry,custname already existed.");
			//this.addActionError(this.getText("custname.exist"));
			e.printStackTrace();
			return "regfail";
		}
	}
}
