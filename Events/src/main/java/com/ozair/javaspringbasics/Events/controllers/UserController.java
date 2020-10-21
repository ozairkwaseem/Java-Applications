package com.ozair.javaspringbasics.Events.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ozair.javaspringbasics.Events.models.Location;
import com.ozair.javaspringbasics.Events.models.User;
import com.ozair.javaspringbasics.Events.repositories.EventsRepository;
import com.ozair.javaspringbasics.Events.repositories.MessageRepository;
import com.ozair.javaspringbasics.Events.repositories.UserRepository;
import com.ozair.javaspringbasics.Events.services.EventsService;
import com.ozair.javaspringbasics.Events.services.UserService;
import com.ozair.javaspringbasics.Events.validations.UserValidator;

@Controller
public class UserController {

	@Autowired
	private EventsRepository eRepo;
	@Autowired 
	private UserRepository uRepo;
	@Autowired
	private MessageRepository mRepo;
	@Autowired
	private EventsService eService;
	@Autowired
	private UserService uService;
	@Autowired
	private UserValidator userValidator;
	
	@GetMapping("/")
	public String EventsIndex(@ModelAttribute("registration") User user, Model model) {
		model.addAttribute("states",Location.States);
		return"/users/userIndex.jsp";
	}
	@PostMapping("/")
	public String register(@Valid @ModelAttribute("registration") User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result);
		if(result.hasErrors())
			return "/users/userIndex.jsp";
		User newUser = this.uService.userRegistration(user);
		session.setAttribute("userid", newUser.getId());
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email")String email, @RequestParam("password") String password, HttpSession session, RedirectAttributes redirect) {
		if(this.uService.authenticateUser(email, password)) {
			User user = this.uService.getuserByEmail(email);
			session.setAttribute("userid", user.getId());
			System.out.println(session.getAttribute("userid"));
			return "redirect:/eventspage";
		}
		redirect.addFlashAttribute("error", "Invalid Email or Password!");
		return "redirect:/";
	}
	
}
