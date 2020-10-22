package com.ozair.javaspringbasics.Events.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ozair.javaspringbasics.Events.models.Message;


@Repository
public interface MessageRepository extends CrudRepository<Message, Long>{
	Message findByEvent(String event);

}