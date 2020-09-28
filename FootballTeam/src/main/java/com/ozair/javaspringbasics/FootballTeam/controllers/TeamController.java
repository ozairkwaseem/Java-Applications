package com.ozair.javaspringbasics.FootballTeam.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ozair.javaspringbasics.FootballTeam.models.Team;
import com.ozair.javaspringbasics.FootballTeam.services.TeamService;

@RestController

public class TeamController {
	private TeamService tService;
	public TeamController(TeamService service) {
		this.tService = service;
	}
	
	//Routes 
	
	@RequestMapping("/")
	public List<Team> index(){
		return this.tService.getAllTeams();
		
	}
	@RequestMapping("{id}")
	public Team getTeam(@PathVariable("id")Long id) {
		return this.tService.getOneTeam(id);
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public Team create(Team newTeam) {
		return this.tService.createTeam(newTeam);
	}
	@RequestMapping(value="/team/update/{id}", method=RequestMethod.PUT)
	public Team edit(@PathVariable("id")Long id, Team updatedTeam) {
		return this.tService.updateTeam(updatedTeam);
		
	}
	@RequestMapping(value="/team/delete/{id}", method=RequestMethod.DELETE)
	public String removeTeam(@PathVariable("id")Long id) {
		this.tService.deleteTeam(id);
		return id + " has been removed from the database";
		
	}
}
