package whu.don.dao;

import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;

import whu.don.vo.Customer;

public class CustomerDAOHibernateTemplateImpl implements CustomerDAO {
	private HibernateTemplate hibTemplate;
	public void setHibTemplate(HibernateTemplate hibTemplate) {
		this.hibTemplate = hibTemplate;
	}
	public void insert(Customer cust) {
		// TODO Auto-generated method stub
		hibTemplate.save(cust);
	}
	public List<Customer> selectAll() {
		// TODO Auto-generated method stub
		String hql="from Customer";
		List<Customer> list=(List<Customer>)hibTemplate.find(hql);
		return list;
	}
	public Customer selectByName(String custname) {
		// TODO Auto-generated method stub
		String hql="from Customer where custname=?";
		List<Customer> list=(List<Customer>)hibTemplate.find(hql,custname);
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

	public Customer selectByNamePwd(String custname, String pwd) {
		// TODO Auto-generated method stub
		String hql="from Customer where custname=? and pwd=?";
		List<Customer> list=(List<Customer>)hibTemplate.find(hql,new String[]{custname,pwd});
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

}
