package com.ozair.javaspringbasics.FootballTeam.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ozair.javaspringbasics.FootballTeam.models.Player;
import com.ozair.javaspringbasics.FootballTeam.services.PlayerService;
import com.ozair.javaspringbasics.FootballTeam.services.TeamService;


@Controller
@RequestMapping("/players")
public class PlayerController {
	@Autowired
	private TeamService tService;
	@Autowired
	private PlayerService pService;
	
	
	@GetMapping("")
	public String createPlayer(@ModelAttribute("player") Player player, Model viewModel) {
		viewModel.addAttribute("team", this.tService.getAllTeams());
		return "players/new.jsp";
	}
	
	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("player") Player newPlayer, BindingResult result, Model viewModel) {
		if(result.hasErrors()) {
			viewModel.addAttribute("team", this.tService.getAllTeams());
			return "players/new.jsp";
		} else {
			this.pService.create(newPlayer);
			return "redirect:/";
		}
	}
}