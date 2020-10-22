package com.ozair.javaspringbasics.FootballTeam.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozair.javaspringbasics.FootballTeam.models.Owner;
import com.ozair.javaspringbasics.FootballTeam.repositories.OwnerRepository;

@Service
public class OwnerService {
	@Autowired
	private OwnerRepository oRepo;
	
	
	public Owner find(Long id) {
		Owner owner = this.oRepo.findById(id).orElse(null);
		return owner;
	}
	
	public List<Owner> allOwners(){
		return this.oRepo.findAll();
	}
	
	public Owner registerOwner(Owner newOwner) {
		// Generate Hash
		String hash = BCrypt.hashpw(newOwner.getPassword(), BCrypt.gensalt());
		// Set the hashed password on the Owner's password field
		newOwner.setPassword(hash);
		//Save the new owner with the salted password to the database
		return this.oRepo.save(newOwner);
	}
	
	//Login Authentication
	public boolean authenticateUser(String email, String password) {
		// Make sure the user logging in is who they say they are
		//step 1: try and query
		Owner owner = this.oRepo.findByEmail(email);
		if(owner == null) {
			return false;
		}
		
		//Step 2 check provided email aginst email in the database for Owner
		return BCrypt.checkpw(password, owner.getPassword());
	}
	
	public Owner getByEmail(String email) {
		return this.oRepo.findByEmail(email);
	}
}
