package org.vermeg.bookstore.test.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.vermeg.bookstore.interfaces.CommandInterface;
import org.vermeg.bookstore.model.Command;
import org.vermeg.bookstore.model.Book;
import org.vermeg.bookstore.model.User;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

class CommandServiceTest {
	Command c1;
	Command c2;
	User user;
	CommandInterface commandInterface=mock(CommandInterface.class);

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
	void testGetAllCommands() {
		user=new User(1,6991245,"hanaa","aa",3);
		c1=new Command(1,"2020-12-05",user);
		c2=new Command(2,"2020-12-02",user);
		int iduser = (int) user.getId();
		List <Command>listcommand= new ArrayList<Command>();
		listcommand.add(c1);
		listcommand.add(c2);
		when(commandInterface.getAllCommands(iduser)).thenReturn(listcommand);
		assertEquals(c1,listcommand.get(0) ,"commande différent");
		assertEquals(c2,listcommand.get(1)," commande différent");
	}

	@Test
	void testGetCommand() {
		user=new User(1,6991245,"hanaa","aa",3);
		c1=new Command(1,"2020-12-05",user);
		int idc = (int) c1.getId();
		when(commandInterface.getAllCommands(idc)).thenReturn((List<Command>) c1);
		assertEquals(c1,commandInterface.getCommand(idc) ,"commande différent");
	
	}

	@Test
	void testAddCommand() {
		user=new User(1,6991245,"hanaa","aa",3);
		c1=new Command(1,"2020-12-05",user);
		commandInterface.addCommand(c1);
		verify(commandInterface,times(1)).addCommand(c1);
		
		}
	@Test
	void testUpdateCommand() {
		user=new User(1,6991245,"hanaa","aa",3);
		c1=new Command(1,"2020-12-05",user);
		commandInterface.updateCommand(c1);
		verify(commandInterface,times(1)).updateCommand(c1);
	}

	@Test
	void testDeleteCommand() {
		user=new User(1,6991245,"hanaa","aa",3);
		c1=new Command(1,"2020-12-05",user);
		int idc = (int) c1.getId();
		commandInterface.deleteCommand(idc);
		verify(commandInterface,times(1)).deleteCommand(idc);		
		}

}
