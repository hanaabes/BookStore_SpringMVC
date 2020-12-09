package org.vermeg.bookstore.test.service;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.vermeg.bookstore.interfaces.UserInterface;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.vermeg.bookstore.model.User;
import org.vermeg.bookstore.model.Command;
class UserServiceTest {
	User user1;
	User user2;
	UserInterface userInterface = mock(UserInterface.class);
		
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetAllUsers() {
		user1=new User(1,6991245,"hanna","abbes",14);
		user2=new User(2,6933245,"imen","benamor",30);
		List <User>listusers= new ArrayList<User>();
		listusers.add(user1);
		listusers.add(user2);
		when(userInterface.getAllUsers()).thenReturn(listusers);
		assertEquals(user1,listusers.get(0) ,"  User différent");
		assertEquals(user2,listusers.get(1),"  User différent");
	}
	@Test
	void testGetUser() {
		user1=new User(1,6991245,"hanna","abbes",14);
		int idu = (int) user1.getId();
		when(userInterface.getUser(idu)).thenReturn(user1);
		assertEquals(user1,userInterface.getUser(idu),"  User différent");
		
	}

	@Test
	void testAddUser() {
		user1=new User(1,6991245,"hanna","abbes",14);
		userInterface.addUser(user1);
		verify(userInterface,times(1)).addUser(user1);
	}

	@Test
	void testUpdateUser() {
		user1=new User(1,6991245,"hanna","abbes",14);
		userInterface.updateUser(user1);
		verify(userInterface,times(1)).updateUser(user1);
	}

	@Test
	void testDeleteUser() {
		user1=new User(1,6991245,"hanna","abbes",14);
		int idu = (int) user1.getId();
		userInterface.deleteUser(idu);
		verify(userInterface,times(1)).deleteUser(idu);
	}

}
