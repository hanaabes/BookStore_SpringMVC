package org.vermeg.bookstore.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.vermeg.bookstore.model.CommandLine;
import org.vermeg.bookstore.service.CommandLineService;

@RestController
@RequestMapping("/api/CommandLine")

public class CommandLineController {
	
	@Autowired
	CommandLineService achatService;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json")
    public String sayHello(){
        return "Hello";
    }
	
	@RequestMapping(value = "/getAllAchats", method = RequestMethod.GET, produces = "application/json")
	public List<CommandLine> getCommandLines(@PathVariable int idorder) {
		
		List<CommandLine> listOfAchats = achatService.getAllCommandLines(idorder);
		achatService.calculeTotal(listOfAchats);
		
		return listOfAchats;
	}

	@RequestMapping(value = "/getCommandLine/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public CommandLine getCommandLineById(@PathVariable int id) {
		return achatService.getCommandLine(id);
	}

	@RequestMapping(value = "/addAchat", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addCommandLine(@ModelAttribute("achat") CommandLine achat) {	
		if(achat.getNumLigne()==0)
		{
			achatService.addCommandLine(achat);
		}
		else
		{	
			achatService.updateCommandLine(achat);
		}
		
		return "redirect:/getAllCommandLines";
	}

	@RequestMapping(value = "/updateCommandLine/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public String updateCommandLine(@PathVariable("id") int id,@ModelAttribute("achat") CommandLine achat,Model model) {
		if(achatService.getCommandLine(id)==null)
		{
			System.out.print( "ligne de commande souhaité n'existe pas");
		}
		else
		{
			achatService.updateCommandLine(achat);
			System.out.print( "modification avec succées");
		}
		return "redirect:/getAllCommandLines";
	}

	@RequestMapping(value = "/deleteCommandLine/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public String deleteCommandLine(@PathVariable("id") int id) {
		achatService.deleteCommandLine(id);
		 return "redirect:/getAllCommandLines";

	}	

}
