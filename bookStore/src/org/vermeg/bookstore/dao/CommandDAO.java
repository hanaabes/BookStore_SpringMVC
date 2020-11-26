package org.vermeg.bookstore.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.vermeg.bookstore.interfaces.CommandInterface;
import org.vermeg.bookstore.model.Command;

@Repository
public class CommandDAO implements CommandInterface {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Command> getAllCommands(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Command> cList = session.createQuery("from orderbook where orderbook.iduser = id").list();
		
		for (Command da:cList) {
			System.out.println(da.toString());
		}
		
		return cList;
	}

	public Command getCommand(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Command c = (Command) session.get(Command.class, new Integer(id));
		return c ;
	}

	public Command addCommand(Command c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(c);
		return c ;
	}

	public void updateCommand(Command c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(c);
	}

	public void deleteCommand(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Command da = (Command) session.load(Command.class, new Integer(id));
		if (null != da) {
			session.delete(da);
		}
	}	

}
