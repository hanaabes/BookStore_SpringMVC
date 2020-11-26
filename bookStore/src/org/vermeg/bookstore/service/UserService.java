package org.vermeg.bookstore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vermeg.bookstore.dao.UserDAO;
import org.vermeg.bookstore.interfaces.UserInterface;
import org.vermeg.bookstore.model.User;

@Service("userService")
public class UserService {
	
	@Autowired
	UserInterface userInterface;
	
	@Transactional
	public List<User> getAllUsers() {
		return userInterface.getAllUsers();
	}

	@Transactional
	public User getUser(int id) {
		return userInterface.getUser(id);
	}

	@Transactional
	public void addUser(User Utilisateur) {
		userInterface.addUser(Utilisateur);
	}

	@Transactional
	public void updateUser(User Utilisateur) {
		userInterface.updateUser(Utilisateur);

	}

	@Transactional
	public void deleteUser(int id) {
		userInterface.deleteUser(id);
	}

}


