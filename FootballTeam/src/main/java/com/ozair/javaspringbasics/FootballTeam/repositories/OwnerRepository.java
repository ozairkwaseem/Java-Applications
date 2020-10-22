package com.ozair.javaspringbasics.FootballTeam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ozair.javaspringbasics.FootballTeam.models.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long>{

	List<Owner> findAll();
	boolean existsByEmail(String email);
	Owner findByEmail(String email);
	
	}
