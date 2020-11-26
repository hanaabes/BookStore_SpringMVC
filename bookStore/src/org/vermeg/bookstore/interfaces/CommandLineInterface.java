package org.vermeg.bookstore.interfaces;

import java.util.List;

import org.vermeg.bookstore.model.CommandLine;



public interface CommandLineInterface {
	
	public List<CommandLine> getAllCommandLines(long orderid);
	
	public CommandLine getCommandLine(int orderid);
	
	public CommandLine addCommandLine(CommandLine achat);
	
	public void updateCommandLine(CommandLine achat);
	
	public void deleteCommandLine(int id);
	
	

}
