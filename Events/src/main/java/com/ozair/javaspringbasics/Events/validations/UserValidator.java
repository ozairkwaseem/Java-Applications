package com.ozair.javaspringbasics.Events.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.ozair.javaspringbasics.Events.models.User;
import com.ozair.javaspringbasics.Events.repositories.EventsRepository;
import com.ozair.javaspringbasics.Events.repositories.UserRepository;

@Component
public class UserValidator {

	@Autowired
	private EventsRepository eRepo;
	@Autowired 
	private UserRepository uRepo;
	
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		if(this.uRepo.findByEmail(user.getEmail()) != null) {
			errors.rejectValue("email", "Unique", "Email taken or not valid!!");
		}
		if(!user.getPasswordValidation().equals(user.getPassword())) {
		errors.rejectValue("passwordValidation",  "Match", "Password does not match!!!");	
		
		}
	}
	
	
}
