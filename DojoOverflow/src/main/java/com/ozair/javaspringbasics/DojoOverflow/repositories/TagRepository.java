package com.ozair.javaspringbasics.DojoOverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ozair.javaspringbasics.DojoOverflow.models.Tag;
import com.sun.el.stream.Optional;

public interface TagRepository  extends CrudRepository<Tag, Long>{
	List<Tag> findAll();
	Optional <Tag> findBySubject(String subject);
}