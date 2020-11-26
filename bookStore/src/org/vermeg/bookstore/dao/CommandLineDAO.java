package org.vermeg.bookstore.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.vermeg.bookstore.interfaces.CommandLineInterface;
import org.vermeg.bookstore.model.CommandLine;



@Repository
public class CommandLineDAO implements CommandLineInterface{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<CommandLine> getAllCommandLines(long orderid) {
		Session session = this.sessionFactory.getCurrentSession();
		List<CommandLine> achatList = session.createQuery("from lineorder where lineorder.orderid = orderid").list();
		
		for (CommandLine a:achatList) {
			System.out.println(a.toString());
		}
		
		return achatList;
	}
	
	public CommandLine getCommandLine(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		CommandLine achat = (CommandLine) session.get(CommandLine.class, new Integer(id));
		return achat;
	}
	
	public CommandLine addCommandLine(CommandLine achat) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(achat);
		return achat;
	}

	public void updateCommandLine(CommandLine achat) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(achat);
	}

	public void deleteCommandLine(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		CommandLine a = (CommandLine) session.load(CommandLine.class, new Integer(id));
		if (null != a) {
			session.delete(a);
		}
	}	
}
