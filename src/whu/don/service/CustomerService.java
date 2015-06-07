package whu.don.service;

import java.util.List;

import whu.don.exception.RegisterException;
import whu.don.vo.Customer;

public interface CustomerService {
	public boolean login(String custname,String pwd);
	public boolean testName(String custname);
	public void register(Customer cust)throws RegisterException;
	public Customer viewPersonal(String custname);
	public List<Customer> viewAll();
}
