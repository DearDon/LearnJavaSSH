package whu.don.service;

import java.util.List;

import whu.don.dao.CustomerDAO;
import whu.don.dao.CustomerDAOImpl;
import whu.don.exception.RegisterException;
import whu.don.vo.Customer;

public class CustomerServiceImpl implements CustomerService{
	private CustomerDAO dao;
	
	public void setDao(CustomerDAO dao) {
		this.dao = dao;
	}

	public boolean login(String custname,String pwd){
		Customer cust=dao.selectByNamePwd(custname, pwd);
		if(cust!=null){
			return true;
		}else{
			return false;
		}
	}
	
	public void register(Customer cust) throws RegisterException{
		Customer c=dao.selectByName(cust.getCustname());
		if(c==null){
			dao.insert(cust);
			
		}else{
			throw new RegisterException();
		}
	}
	
	public Customer viewPersonal(String custname){
		return dao.selectByName(custname);
	}
	
	public List<Customer> viewAll(){
		return dao.selectAll();
	}
	
	public static void main(String[] args){
		CustomerServiceImpl cs=new CustomerServiceImpl();
		cs.setDao(new CustomerDAOImpl());
		boolean flag=cs.login("ETC", "123");
		System.out.println(flag);
		
//		Customer c=new Customer("John","123",34,"TJ");
//		boolean flag=cs.register(c);
//		System.out.println(flag);
		
//		Customer c=cs.viewPersonal("John");
		
		try {
			cs.register(new Customer("John122","123",34,"TJ"));
		} catch (RegisterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		List<Customer> list=cs.viewAll();
		for(Customer c:list){
			System.out.println(c.getCustname()+" "+c.getPwd()+" "+c.getAge()+" "+c.getAddress());
			
		}
	}
}
