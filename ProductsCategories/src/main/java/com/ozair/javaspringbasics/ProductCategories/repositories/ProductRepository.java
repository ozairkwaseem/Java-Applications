package com.ozair.javaspringbasics.ProductCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ozair.javaspringbasics.ProductCategories.models.Category;
import com.ozair.javaspringbasics.ProductCategories.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
	List<Product> findAll();
	List<Product> findByCategoriesNotContains(Category category);
}