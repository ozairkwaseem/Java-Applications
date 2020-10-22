package com.ozair.javaspringbasics.FootballTeam.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity 
@Table(name="owners")
public class Owner {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(max=15)
	private String firstName;
	@NotBlank
	@Size(max=30)
	private String lastName;
	private Long netWorth;
	@Email
	@NotBlank
	private String email;
	private String password;
	@Transient
	private String confirmPassword;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="likes",
			joinColumns= @JoinColumn(name="owner_id"),
			inverseJoinColumns= @JoinColumn(name="team_id")
			)
	private List<Team> likedTeams;
	
	
	public Owner() {
		
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


	public Long getNetWorth() {
		return netWorth;
	}


	public void setNetWorth(Long netWorth) {
		this.netWorth = netWorth;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


	public List<Team> getLikedTeams() {
		return likedTeams;
	}


	public void setLikedTeams(List<Team> likedTeams) {
		this.likedTeams = likedTeams;
	}
	
	
	
	
}
