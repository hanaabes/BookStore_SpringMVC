package org.vermeg.bookstore.test.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.vermeg.bookstore.interfaces.CommandLineInterface;
import org.vermeg.bookstore.model.CommandLine;
import org.vermeg.bookstore.model.Command;
import org.vermeg.bookstore.model.Book;
import org.vermeg.bookstore.model.User;
import org.vermeg.bookstore.service.CommandLineService;
class CommandLineServiceTest {
	CommandLine commandline;
	CommandLine commandline1;
	Book book;
	Command command;
	CommandLineService commandlineService;
	User user;
	CommandLineInterface commandlineInterface = mock(CommandLineInterface.class);

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
	void testGetAllCommandLines() {
		user=new User(1,699875,"rr","yy",22);
		book=new Book(1,10001,"aaa","b","2020-01-12","f",700);
		command = new Command(1,"2020-12-15",user);
		commandline = new CommandLine(1,15,book,command);
		commandline1 = new CommandLine(2,20,book,command);
		int orderid=(int) Command.getId();
		List <CommandLine>listcommandline= new ArrayList<CommandLine>();
		listcommandline.add(commandline);
		listcommandline.add(commandline1);
		when(commandlineInterface.getCommandLine(orderid)).thenReturn((CommandLine) listcommandline);
		assertTrue(listcommandline.get(0).getCommand() == command ,"ajouter avec une commande différente ");
		assertTrue(listcommandline.get(0).getLivre()== book ,"ajouter avec un livre différent  ");
		assertTrue(listcommandline.get(0).getCommand() == command ,"ajouter avec une command différent ");
		assertTrue(listcommandline.get(0).getQuantite() == 15,"ajouter avec une quantite différente");
		assertTrue(listcommandline.get(0).getPrixpd()== listcommandline.get(0).getQuantite()* listcommandline.get(0).getLivre().getPrixUnitaire(),"ajouter avec un prix de produit incorrect");
		assertTrue(listcommandline.get(1).getCommand() == command ,"ajouter avec une commande différente");
		assertTrue(listcommandline.get(1).getLivre()== book ,"ajouter avec un Livre différent");
		assertTrue(listcommandline.get(1).getCommand() == command ,"ajouter avec une commande  différente ");
		assertTrue(listcommandline.get(1).getQuantite() == 20,"ajouter avec une quantite différente");
		assertTrue(listcommandline.get(1).getPrixpd()== listcommandline.get(1).getQuantite()* listcommandline.get(1).getLivre().getPrixUnitaire(),"ajouter avec un prix de produit incorrect");
		assertEquals(2,listcommandline.size(),"taille de liste incorrect");
		
	}

	@Test
	void testGetCommandLine() {
		user=new User(1,699875,"rr","yy",22);
		book=new Book(1,10001,"aaa","b","2020-01-12","f",700);
		command = new Command(1,"2020-12-15",user);
		commandline = new CommandLine(1,15,book,command);
		int numLigne=(int) commandline.getNumLigne();
		when(commandlineInterface.getCommandLine(numLigne)).thenReturn(commandline);
		assertTrue(commandline.getCommand() == command ,"ajouter avec un document commandline différent que ajouté avec");
		assertTrue(commandline.getLivre()== book ,"ajouter avec un livre différent que ajouté avec");
		assertTrue(commandline.getCommand() == command ,"ajouter avec un document commandline différent que ajouté avec");
		assertTrue(commandline.getQuantite() == 15,"ajouter avec une quantite différente que ajouté avec");
		assertTrue(commandline.getPrixpd()== commandline.getQuantite()* commandline.getLivre().getPrixUnitaire(),"ajouter avec un prix de produit incorrect");
		assertEquals(commandline,commandline,"c'est pas la meme instance");
		
	}

	@Test
	void testAddCommandLine() {
		user=new User(1,699875,"rr","yy",22);
		book=new Book(1,10001,"aaa","b","2020-01-12","f",700);
		command = new Command(1,"2020-12-15",user);
		commandline = new CommandLine(1,15,book,command);
		commandlineInterface.addCommandLine(commandline);
		verify(commandlineInterface,times(1)).addCommandLine(commandline);
		
	}

	@Test
	void testUpdateCommandLine() {
		user=new User(1,699875,"rr","yy",22);
		book=new Book(1,10001,"aaa","b","2020-01-12","f",700);
		command = new Command(1,"2020-12-15",user);
		commandline = new CommandLine(1,15,book,command);
		commandlineInterface.updateCommandLine(commandline);
		verify(commandlineInterface,times(1)).updateCommandLine(commandline);
	
	}

	@Test
	void testDeleteCommandLine() {
		user=new User(1,699875,"rr","yy",22);
		book=new Book(1,10001,"aaa","b","2020-01-12","f",700);
		command = new Command(1,"2020-12-15",user);
		commandline = new CommandLine(1,15,book,command);
		commandlineInterface.deleteCommandLine((int) commandline.getNumLigne());
		verify(commandlineInterface,times(1)).deleteCommandLine((int) commandline.getNumLigne());
	
	}

	

}
