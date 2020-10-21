package com.ozair.javaspringbasics.Events.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="events")
public class Events {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank	
	private String EventName;
	@NotBlank
	private String city;
	private String state;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="event")
	private List<Message> messages;
	@Future
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	private Date date;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userid")
	private User host;
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="user_events",
			joinColumns= @JoinColumn(name="event_id"),
			inverseJoinColumns= 	@JoinColumn(name="user_id")
			)
	private List<User> guests;
	
	public Events() {
		
	}
    public String getEventDateFormatted() {
    	SimpleDateFormat dateformat = new SimpleDateFormat("dd,MM,YYYY");
    	return dateformat.format(this.date);
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEventName() {
		return EventName;
	}
	public void setEventName(String eventName) {
		EventName = eventName;
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
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public User getHost() {
		return host;
	}
	public void setHost(User host) {
		this.host = host;
	}
	public List<User> getGuests() {
		return guests;
	}
	public void setGuests(List<User> guests) {
		this.guests = guests;
	}


	
	
}
	
	
