package com.ozair.javaspringbasics.FootballTeam.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ozair.javaspringbasics.FootballTeam.models.Player;

@Repository
	public interface PlayerRepository extends CrudRepository<Player, Long>{
		
	}

