package org.vermeg.bookstore.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.vermeg.bookstore.model.User;
import org.vermeg.bookstore.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json")
    public String sayHello(){
        return "Hello";
    }
	
	@RequestMapping(value = "/getAllUtilisateurs", method = RequestMethod.GET, produces = "application/json")
	public List<User> getUsers() {
		
		List<User> listOfUsers = userService.getAllUsers();
		
		return listOfUsers;
	}

	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public User getUserById(@PathVariable int id) {
		return userService.getUser(id);
	}

	@RequestMapping(value = "/addUtilisateur", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addUtilisateur(@ModelAttribute("utilisateur") User utilisateur) {	
		if(utilisateur.getId()==0)
		{
			userService.addUser(utilisateur);
		}
		else
		{	
			userService.updateUser(utilisateur);
		}
		
		return "redirect:/getAllUtilisateurs";
	}

	@RequestMapping(value = "/updateUtilisateur/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public String updateUtilisateur(@PathVariable("id") int id,@ModelAttribute("utilisateur") User utilisateur,Model model) {
		if(userService.getUser(id)==null)
		{
			System.out.print( "le utilisateur souhaité n'existe pas");
		}
		else
		{
			userService.updateUser(utilisateur);
			System.out.print( "modification avec succées");
		}
		return "redirect:/getAllUtilisateurs";
	}

	@RequestMapping(value = "/deleteUtilisateur/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public String deleteUtilisateur(@PathVariable("id") int id) {
		userService.deleteUser(id);
		 return "redirect:/getAllUtilisateurs";

	}	

}
