package org.vermeg.bookstore.service;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vermeg.bookstore.dao.CommandLineDAO;
import org.vermeg.bookstore.interfaces.CommandLineInterface;
import org.vermeg.bookstore.model.CommandLine;

@Service("achatService")
public class CommandLineService {

	
	@Autowired
	CommandLineInterface achatInterface;
	
	@Transactional
	public List<CommandLine> getAllCommandLines(long orderid) {
		return achatInterface.getAllCommandLines(orderid);
	}
	
	@Transactional
	public CommandLine getCommandLine(int id) {
		return achatInterface.getCommandLine(id);
	}

	@Transactional
	public void addCommandLine(CommandLine livre) {
		achatInterface.addCommandLine(livre);
	}

	@Transactional
	public void updateCommandLine(CommandLine livre) {
		achatInterface.updateCommandLine(livre);

	}

	@Transactional
	public void deleteCommandLine(int id) {
		achatInterface.deleteCommandLine(id);
	}
	
	@Transactional
	public double calculeTotal(List<CommandLine> listOfAchats) {
		double somme=0;
		int i=0;
		do {
			somme = somme+listOfAchats.get(i).getPrixpd();
			i++;
		}
		while(i<listOfAchats.size());
		return somme;
	}

}
