package org.vermeg.bookstore.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.vermeg.bookstore.model.Command;
import org.vermeg.bookstore.service.CommandService;

@RestController
@RequestMapping("/api/command")
public class CommandController {
	
	@Autowired
	CommandService cService;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json")
    public String sayHello(){
        return "Hello";
    }
	
	@RequestMapping(value = "/getAllCommands", method = RequestMethod.GET, produces = "application/json")
	public List<Command> getCommands(@PathVariable int iduser) {
		
		List<Command> listOfDocumentAchats = cService.getAllCommands(iduser);
		
		return listOfDocumentAchats;
	}

	@RequestMapping(value = "/getCommand/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Command getCommandById(@PathVariable int id) {
		return cService.getCommand(id);
	}

	@RequestMapping(value = "/addCommand", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addCommand(@ModelAttribute("documentAchat") Command cd) {	
		if(cd.getId()==0)
		{
			cService.addCommand(cd);
		}
		else
		{	
			cService.updateCommand(cd);
		}
		
		return "redirect:/getAllCommands";
	}

	@RequestMapping(value = "/updateDocumentAchat/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public String updateCommand(@PathVariable("id") int id,@ModelAttribute("documentAchat") Command c,Model model) {
		if(cService.getCommand(id)==null)
		{
			System.out.print( "la commande souhaité n'existe pas");
		}
		else
		{
			cService.updateCommand(c);
			System.out.print( "modification avec succées");
		}
		return "redirect:/getAllCommands";
	}

	@RequestMapping(value = "/deleteCommand/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public String deleteCommand(@PathVariable("id") int id) {
		cService.deleteCommand(id);
		 return "redirect:/getAllCommands";

	}	

}
