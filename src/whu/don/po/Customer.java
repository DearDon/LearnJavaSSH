package whu.don.po;

/**
 * Customer entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Customer implements java.io.Serializable {

	// Fields

	private String custname;
	private String pwd;
	private Integer age;
	private String address;

	// Constructors

	/** default constructor */
	public Customer() {
	
	}
	
	public Customer(String custname) {
		super();
		this.custname = custname;
	}

	/** minimal constructor */
	public Customer(String custname, String pwd) {
		this.custname = custname;
		this.pwd = pwd;
	}

	/** full constructor */
	public Customer(String custname, String pwd, Integer age, String address) {
		this.custname = custname;
		this.pwd = pwd;
		this.age = age;
		this.address = address;
	}

	// Property accessors

	public String getCustname() {
		return this.custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}