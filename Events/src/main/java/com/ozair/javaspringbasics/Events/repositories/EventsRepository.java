package com.ozair.javaspringbasics.Events.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ozair.javaspringbasics.Events.models.Events;

@Repository
public interface EventsRepository extends CrudRepository<Events, Long>{
	List<Events> findAll();
	List<Events> findByStateContaining(String state);
	List<Events> findByStateIsNot(String state);

}
