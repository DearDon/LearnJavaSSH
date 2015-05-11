package whu.don.action;

import java.util.List;

import whu.don.dao.CustomerDAOImpl;
import whu.don.service.CustomerService;
import whu.don.service.CustomerServiceImpl;
import whu.don.vo.Customer;

import com.opensymphony.xwork2.ActionContext;

public class ViewAllAction {
	public String execute(){
		CustomerServiceImpl cs=new CustomerServiceImpl();
		cs.setDao(new CustomerDAOImpl());
		List<Customer> list=cs.viewAll();
		ActionContext ctxt=ActionContext.getContext();
		ctxt.put("allcustomers", list);
		return "success";
	}
}
