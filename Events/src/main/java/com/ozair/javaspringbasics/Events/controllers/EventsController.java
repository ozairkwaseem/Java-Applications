package com.ozair.javaspringbasics.Events.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ozair.javaspringbasics.Events.models.Events;
import com.ozair.javaspringbasics.Events.models.Location;
import com.ozair.javaspringbasics.Events.models.User;
import com.ozair.javaspringbasics.Events.repositories.EventsRepository;
import com.ozair.javaspringbasics.Events.repositories.MessageRepository;
import com.ozair.javaspringbasics.Events.repositories.UserRepository;
import com.ozair.javaspringbasics.Events.services.EventsService;
import com.ozair.javaspringbasics.Events.services.UserService;

@Controller
@RequestMapping("/eventspage")
public class EventsController {
	@Autowired
	private EventsRepository eRepo;
	@Autowired 
	private UserRepository uRepo;
	@Autowired
	private MessageRepository mRepo;
	@Autowired
	private EventsService eService;
	@Autowired
	private UserService uService;
	
	
	@GetMapping("")
	public String index(@ModelAttribute("event") Events event, Model model, HttpSession session) {
		Long userId = (Long)session.getAttribute("userid");
		
		model.addAttribute("userId", userId);
		if(userId == null) {

			return "redirect:/";}
		
		User user = this.uService.findById(userId);
		model.addAttribute("EventName", this.eService.getEvents());
		model.addAttribute("usersStates", this.eService.allEventsWithState(user.getState()));
		model.addAttribute("otherStates", this.eService.allEventsNotState(user.getState()));
		model.addAttribute("user", user);
		model.addAttribute("currentDate", currentDate());
		model.addAttribute("states", Location.States);
		return "/events/EventsIndex.jsp";
	}
	
	@PostMapping("")
	public String createEvent(@Valid @ModelAttribute("event") Events event, BindingResult result, Model model, HttpSession session, @RequestParam Map<String,String> body)
	{ if(result.hasErrors()) {
		Long userId = this.userSessionId(session);
		Events user = this.eService.findById(userId);
		model.addAttribute("usersLocations", 		this.eService.allEventsWithState(user.getState()));
		model.addAttribute("otherLocations", this.eService.allEventsNotState(user.getState()));
		model.addAttribute("user", user);
		model.addAttribute("today", currentDate());
		model.addAttribute("locations", Location.States);
		return "/events/EventsIndex.jsp";
	}
	this.eService.create(event);
	return"redirect:/eventspage";
		
	}
	public Long userSessionId(HttpSession session) {
		if(session.getAttribute("userId") == null)
			return null;
		return (Long)session.getAttribute("userId");
	}
	
	private String currentDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(new Date());
	}
	
	@PostMapping("/{id}/comment")
	public String comment(@PathVariable("id")Long id, @RequestParam("comment") String comment, RedirectAttributes redirect, HttpSession session) {
		Long userId = this.userSessionId(session);
		if(userId == null)
			return "redirect:/";
		if(comment.equals("")) {
			redirect.addFlashAttribute("error", "Comments cannot be blank");
			return "redirect:/eventspage/" +id;
		}
		Events event = this.eService.findById(userId);
		User user = this.uService.findById(userId);
		this.eService.comment(user, event, comment);
		return "redirect:/eventspage/"+ id;
	}
	@GetMapping("/{id}/editevent")
	public String editEvent(@PathVariable("id")Long id, HttpSession session,Model model) {
		Long userId = this.userSessionId(session);
		Events event = this.eService.findById(id);
		if(userId == null)
			return "redirect:/";
		if(event == null || !event.getHost().getId().equals(userId))
			return "redirect:/eventspage";
		model.addAttribute("event",event);
		model.addAttribute("states",Location.States);
		model.addAttribute("userId", userId);
		return "/events/editEvents.jsp";
	
	}
	@PutMapping("/{id}")
	public String updateEvent(@Valid @ModelAttribute("event") Events event, BindingResult result,@PathVariable("id")Long id, HttpSession session, Model model) {
		if(result.hasErrors()) {
			Long userId = this.userSessionId(session);
			model.addAttribute("event", event);
			model.addAttribute("states", Location.States);
			model.addAttribute("userId", userId);
			return "/events/editEvents.jsp";
			
		}
		this.eService.update(event);
		return"redirect:/eventspage";
	}
	@DeleteMapping("/{id}")
	public String deleteEvent(@PathVariable("id")Long id) {
		this.eService.delete(id);
		return "redirect:/eventspage";
	}
	@GetMapping("/{id}/a/{choice}")
	public String manageguests(@PathVariable("id") Long id, @PathVariable("choice")String choice, HttpSession session) {
		Long userId = this.userSessionId(session);
		Events event = this.eService.findById(id);
		boolean isAttending = (choice.equals("join"));
		if(userId == null)
			return "redirect:/";
		User user = this.uService.findById(userId);
		this.eService.manageGuests(event, user, isAttending);
		return "redirect:/eventspage";
	}
	
	
}
