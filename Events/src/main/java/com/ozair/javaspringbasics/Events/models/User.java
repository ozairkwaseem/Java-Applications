package com.ozair.javaspringbasics.Events.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@NotBlank
	private String email;
	@NotBlank
	private String city;
	@NotBlank
	private String state;
	@NotBlank
	@Size(min=8)
	private String password;
	@Transient
	private String passwordValidation;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="host")
	private List<Events> eventsCreated;
	@OneToMany(fetch=FetchType.LAZY, 	mappedBy="eventCreator")
	private List <Message> messages;
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="user_events",
	joinColumns= @JoinColumn(name="user_id"),
	inverseJoinColumns = @JoinColumn(name="event_id")
			)
	private List <Events> eventsAccepted;
	
	
	
	public User() {
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getPasswordValidation() {
		return passwordValidation;
	}



	public void setPasswordValidation(String passwordValidation) {
		this.passwordValidation = passwordValidation;
	}



	public List<Events> getEventsCreated() {
		return eventsCreated;
	}



	public void setEventsCreated(List<Events> eventsCreated) {
		this.eventsCreated = eventsCreated;
	}



	public List<Message> getMessages() {
		return messages;
	}



	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}



	public List<Events> getEventsAccepted() {
		return eventsAccepted;
	}



	public void setEventsAccepted(List<Events> eventsAccepted) {
		this.eventsAccepted = eventsAccepted;
	}




	
}