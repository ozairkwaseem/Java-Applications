package com.ozair.javaspringbasics.ProductCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ozair.javaspringbasics.ProductCategories.models.Category;
import com.ozair.javaspringbasics.ProductCategories.models.Product;

public interface CategoryRepository extends CrudRepository<Category, Long>{
	List<Category> findAll();
	List<Category> findByProductsNotContains(Product product);
}