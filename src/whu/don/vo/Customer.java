package whu.don.vo;

public class Customer {
	private String custname;
	private String pwd;
	private Integer age;
	private String address;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String custname, String pwd, Integer age, String address) {
		super();
		this.custname = custname;
		this.pwd = pwd;
		this.age = age;
		this.address = address;
	}
	public Customer(String custname, String pwd) {
		super();
		this.custname = custname;
		this.pwd = pwd;
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
}
