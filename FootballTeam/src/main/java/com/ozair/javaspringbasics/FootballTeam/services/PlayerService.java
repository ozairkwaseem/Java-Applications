package com.ozair.javaspringbasics.FootballTeam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozair.javaspringbasics.FootballTeam.models.Player;
import com.ozair.javaspringbasics.FootballTeam.repositories.PlayerRepository;

@Service
public class PlayerService{
	@Autowired
	private PlayerRepository pRepo;
	
	public Player create(Player player) {
		return this.pRepo.save(player);
	}
}
