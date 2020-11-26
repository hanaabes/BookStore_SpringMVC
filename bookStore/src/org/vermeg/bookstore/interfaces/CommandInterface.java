package org.vermeg.bookstore.interfaces;

import java.util.List;

import org.vermeg.bookstore.model.Command;

public interface CommandInterface {

	
    public List<Command> getAllCommands(long id);
	
	public Command getCommand(int id);
	
	public Command addCommand(Command c);
	
	public void updateCommand(Command c);
	
	public void deleteCommand(int id);

}