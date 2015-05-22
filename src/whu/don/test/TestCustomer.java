package whu.don.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
 

import whu.don.po.Customer;
import whu.don.util.HibernateSessionFactory;

public class TestCustomer {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Customer cust=new Customer("HBETC","123",18,"BeiJing");
		Session session=HibernateSessionFactory.getSession();
		
		
		Transaction tran=session.beginTransaction();
		//session.save(cust);
		//session.update(new Customer("BJETC","abc",23,"DaLian"));
		Customer c=(Customer) session.get(Customer.class, "BJETC");
		//c.setPwd("abc-update");
		//session.delete(c);
		System.out.println("主键为BJETC的记录详细信息："+c.getCustname()+" "+c.getPwd()+" "+c.getAge()+" "+c.getAddress());
		tran.commit();
		session.close();
		
	}
	
	/*
	public static SessionFactory createSessionFactory() {
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;
	}
	*/
}
