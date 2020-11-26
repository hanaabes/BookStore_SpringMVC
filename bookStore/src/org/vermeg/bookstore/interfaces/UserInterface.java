package org.vermeg.bookstore.interfaces;

import java.util.List;

import org.vermeg.bookstore.model.User;

public interface UserInterface {

		
		public List<User> getAllUsers();
		
		public User getUser(int id);
		
		public User addUser(User u);
		
		public void updateUser(User  u);
		
		public void deleteUser(int id);

	
}
