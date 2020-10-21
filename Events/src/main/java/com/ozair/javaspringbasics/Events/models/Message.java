package com.ozair.javaspringbasics.Events.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="messages")
public class Message {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String messageContent;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User eventCreator;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="event_id")
	private Events event;
	
	public Message(User eventCreator, Events event, String messageContent) {
	    	this.eventCreator = eventCreator;
	    	this.event = event;
	    	this.messageContent = messageContent;
	    }
	public Message() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public User getEventCreator() {
		return eventCreator;
	}
	public void setEventCreator(User eventCreator) {
		this.eventCreator = eventCreator;
	}
	public Events getEvent() {
		return event;
	}
	public void setEvent(Events event) {
		this.event = event;
	}
	
}
