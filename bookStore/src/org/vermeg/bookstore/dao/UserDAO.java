package org.vermeg.bookstore.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.vermeg.bookstore.interfaces.UserInterface;
import org.vermeg.bookstore.model.User;

@Repository
public class UserDAO implements UserInterface {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<User> getAllUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> userList = session.createQuery("from User").list();
		
		for (User u: userList) {
			System.out.println(u.toString());
		}
		
		return userList;
	}

	public User getUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User utilisateur = (User) session.get(User.class, new Integer(id));
		return utilisateur;
	}

	public User addUser(User utilisateur) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(utilisateur);
		return utilisateur;
	}

	public void updateUser(User utilisateur) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(utilisateur);
	}

	public void deleteUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User u = (User) session.load(User.class, new Integer(id));
		if (null != u) {
			session.delete(u);
		}
	}	

}


