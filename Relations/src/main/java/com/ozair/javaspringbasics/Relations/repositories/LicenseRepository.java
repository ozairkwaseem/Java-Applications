package com.ozair.javaspringbasics.Relations.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ozair.javaspringbasics.Relations.models.License;

public interface LicenseRepository extends CrudRepository<License, Long>{
	public List<License> findAll();
	public License findTopByOrderByNumberDesc();
}
