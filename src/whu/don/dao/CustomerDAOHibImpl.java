package whu.don.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import whu.don.vo.Customer;

public class CustomerDAOHibImpl implements CustomerDAO {

	public void insert(Customer cust) {
		// TODO Auto-generated method stub
	  Session session=HibernateSessionFactory.getSession();
	  Transaction tran=session.beginTransaction();
	  session.save(cust);
	  tran.commit();
	}

	public List<Customer> selectAll() {
		// TODO Auto-generated method stub
		Session session=HibernateSessionFactory.getSession();
		String hql="from Customer";
		List<Customer> list=session.createQuery(hql).list();
		return list;
	}

	public Customer selectByName(String custname) {
		// TODO Auto-generated method stub
		Customer cust=null;
		Session session=HibernateSessionFactory.getSession();
		String hql="from Customer where custname='"+custname+"'";
		List<Customer> list=session.createQuery(hql).list();
		if(list.size()>0){
			cust=list.get(0);
		}
		return cust;
	}

	public Customer selectByNamePwd(String custname, String pwd) {
		// TODO Auto-generated method stub
		Session session=HibernateSessionFactory.getSession();
		Customer cust=null;
		String hql="from Customer where custname=? and pwd=?";
		Query query=session.createQuery(hql);
		query.setString(0, custname);
		query.setString(1, pwd);
		List<Customer> list=query.list();
		if(list.size()>0){
			cust=list.get(0);
		}
		return cust;
	}

}
