package com.ozair.javaspringbasics.FootballTeam.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.ozair.javaspringbasics.FootballTeam.models.Owner;
import com.ozair.javaspringbasics.FootballTeam.repositories.OwnerRepository;

@Component
public class OwnerValidator {
	@Autowired
	private OwnerRepository oRepo;
	
	public boolean supports(Class<?> clazz) {
		return Owner.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
	        Owner owner = (Owner) target;
	        

	        if(!owner.getPassword().equals(owner.getConfirmPassword())) {
	        	errors.rejectValue("password", "match", "Passwords do not match!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	        }
	        
	        
	        // Make sure email is unique in the database
	        if(this.oRepo.existsByEmail(owner.getEmail())) {
	        	errors.rejectValue("email", "Unique", "Email is already taken, try again!");
	        }
	        
	        
	    }
}