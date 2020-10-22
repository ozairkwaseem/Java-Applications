package com.ozair.javaspringbasics.FootballTeam.models;



import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="teams")
public class Team {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Size(min=2, max=45, message="Hey, what do you think you're doing with that short/long name?")
	private String name;
	@NotBlank
	@Size(min=2, max=45)
	private String city;
	@NotNull
	private int players;
	@OneToOne(mappedBy="team", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Mascot mascot;
	@OneToMany(mappedBy="team", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Player> player;
	@Column(updatable=false)
	@DateTimeFormat(pattern = "yyy-MM-DD HH:mm:ss")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyy-MM-DD HH:mm:ss")
	private Date updatedAt;
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="likes",
		joinColumns = @JoinColumn(name="team_id"),
		inverseJoinColumns = @JoinColumn(name="owner_id")
		)
	private List<Owner> likers;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	public Team() {
	}
	
	
	public Team(String name, String city, int players) {

		this.name = name;
		this.city = city;
		this.players = players;
	}

	public Long getId() {
		return id;
	}
	public List<Player> getPlayer() {
		return player;
	}

	public void setPlayer(List<Player> player) {
		this.player = player;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPlayers() {
		return players;
	}
	public void setPlayers(int players) {
		this.players = players;
	}
	public Mascot getMascot() {
		return mascot;
	}
	public void setMascot(Mascot mascot) {
		this.mascot = mascot;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Owner> getLikers() {
		return likers;
	}

	public void setLikers(List<Owner> likers) {
		this.likers = likers;
	}
	
	
	
	
}