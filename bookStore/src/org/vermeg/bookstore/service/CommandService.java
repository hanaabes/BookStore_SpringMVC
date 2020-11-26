package org.vermeg.bookstore.service;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vermeg.bookstore.dao.CommandDAO;
import org.vermeg.bookstore.interfaces.CommandInterface;
import org.vermeg.bookstore.model.Command;


@Service("CommandService")
public class CommandService {
	@Autowired
	CommandInterface clInterface;
	
	@Transactional
	public List<Command> getAllCommands(long orderid) {
		return clInterface.getAllCommands(orderid);
	}
	
	@Transactional
	public Command getCommand(int id) {
		return clInterface.getCommand(id);
	}

	@Transactional
	public void addCommand(Command livre) {
		clInterface.addCommand(livre);
	}

	@Transactional
	public void updateCommand(Command livre) {
        clInterface.updateCommand(livre);

	}

	@Transactional
	public void deleteCommand(int id) {
		clInterface.deleteCommand(id);
	}



}
