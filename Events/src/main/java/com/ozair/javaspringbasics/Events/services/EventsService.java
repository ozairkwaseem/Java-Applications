package com.ozair.javaspringbasics.Events.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozair.javaspringbasics.Events.models.Events;
import com.ozair.javaspringbasics.Events.models.Message;
import com.ozair.javaspringbasics.Events.models.User;
import com.ozair.javaspringbasics.Events.repositories.EventsRepository;
import com.ozair.javaspringbasics.Events.repositories.MessageRepository;
import com.ozair.javaspringbasics.Events.repositories.UserRepository;

@Service
public class EventsService {

	@Autowired
	private EventsRepository eRepo;
	@Autowired 
	private UserRepository uRepo;
	@Autowired
	private MessageRepository mRepo;
	
	
	public List<Events> getEvents(){
		return this.eRepo.findAll();
	}
	public List<Events> allEventsNotState(String state) {
		return this.eRepo.findByStateIsNot(state);
	}
	
	public List<Events> allEventsWithState(String state) {
		return this.eRepo.findByStateContaining(state);
	}
	public Events findById(Long id) {
		return this.eRepo.findById(id).orElse(null);
	}
	
	public Events create(Events event) {
		return this.eRepo.save(event);
	}
	public Events update(Events event) {
		return this.eRepo.save(event);
	}
	public void delete(Long id) {
		this.eRepo.deleteById(id);
	}
	public void comment(User user, Events event, String comment) {
		this.mRepo.save(new Message(user, event, comment));
	}
	public void manageGuests(Events event, User user, boolean isJoining) {
		if(isJoining) {
			event.getGuests().add(user);
		} else {
			event.getGuests().remove(user);
		}
		this.eRepo.save(event);
	}

	
}
