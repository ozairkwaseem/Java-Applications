package com.ozair.javaspringbasics.FootballTeam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozair.javaspringbasics.FootballTeam.models.Mascot;
import com.ozair.javaspringbasics.FootballTeam.repositories.MascotRepository;


	@Service
	public class MascotService {
		@Autowired
		private MascotRepository mRepo;
		
		// Create Method
		public Mascot create(Mascot mascot) {
			return this.mRepo.save(mascot);
		}
	}
	
