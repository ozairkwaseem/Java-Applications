package com.ozair.javaspringbasics.FootballTeam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ozair.javaspringbasics.FootballTeam.models.Owner;
import com.ozair.javaspringbasics.FootballTeam.services.OwnerService;
import com.ozair.javaspringbasics.FootballTeam.validations.OwnerValidator;
@Controller
public class OwnerController {
	@Autowired 
	private OwnerService oService;
	@Autowired
	private OwnerValidator validator;
	
	
	@RequestMapping("/")
	private String index(@ModelAttribute("owner") Owner owner) {
		return "landing.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("owner") Owner owner, BindingResult result, HttpSession session) {
		validator.validate(owner, result);
		if(result.hasErrors()) {
			// if there are validation errors, we want to send them to the fornt page
			return "landing.jsp";
		} 
		Owner newOwner = this.oService.registerOwner(owner);
		session.setAttribute("owner_id", newOwner.getId());
		return "redirect:/teams";		
		
	}
	
	@PostMapping("/login")
	public String login(HttpSession session, @RequestParam("lemail") String email, @RequestParam("lpassword") String password, RedirectAttributes redirectAttrs) {
		if(!this.oService.authenticateUser(email, password)) {
			redirectAttrs.addFlashAttribute("loginError", "Invalid Credentials");
			return "redirect:/";
		}
		Owner owner = this.oService.getByEmail(email);
		session.setAttribute("owner_id", owner.getId());
		return "redirect:/teams";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}