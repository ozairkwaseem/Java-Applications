package com.ozair.javaspringbasics.FootballTeam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ozair.javaspringbasics.FootballTeam.models.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {
	List<Team> findAll();
}

/*
C - Create
R - Read
U- Update
D - Delete
*/