package whu.don.action;

import java.util.List;

import whu.don.service.CustomerService;
import whu.don.vo.Customer;

import com.opensymphony.xwork2.ActionContext;

public class ViewAllAction {
	/*
	public String execute(){
		CustomerServiceImpl cs=new CustomerServiceImpl();
		cs.setDao(new CustomerDAOHibImpl());
		List<Customer> list=cs.viewAll();
		ActionContext ctxt=ActionContext.getContext();
		ctxt.put("allcustomers", list);
		return "success";
	}
	*/
	private List<Customer> list;
    private CustomerService service;
	
	public void setService(CustomerService service) {
		this.service = service;
	}

	public List<Customer> getList() {
		return list;
	}
	
	public String execute(){
		list=service.viewAll();
		return "success";
	}
}
