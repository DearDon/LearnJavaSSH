package whu.don.dao;
import java.util.List;

import whu.don.vo.Customer;

public interface CustomerDAO {
	public void insert(Customer cust);
	public Customer selectByName(String custname);
	public Customer selectByNamePwd(String custname,String pwd);
	public List<Customer> selectAll();
}
