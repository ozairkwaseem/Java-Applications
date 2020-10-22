package com.ozair.javaspringbasics.ProductCategories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ozair.javaspringbasics.ProductCategories.models.Association;
import com.ozair.javaspringbasics.ProductCategories.models.Category;
import com.ozair.javaspringbasics.ProductCategories.models.Product;
import com.ozair.javaspringbasics.ProductCategories.repositories.AssociationRepository;
import com.ozair.javaspringbasics.ProductCategories.repositories.CategoryRepository;
import com.ozair.javaspringbasics.ProductCategories.repositories.ProductRepository;

@Service
public class AppService {
	private final ProductRepository pRepo;
	private final CategoryRepository cRepo;
	private final AssociationRepository aRepo;
	public AppService(ProductRepository pRepo, CategoryRepository cRepo, AssociationRepository aRepo) {
		this.pRepo = pRepo;
		this.cRepo = cRepo;
		this.aRepo = aRepo;
	}
	public List<Product> findProducts() {
		return this.pRepo.findAll();
	}
	public Product getProduct(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	public List<Category> findCategories() {
		return this.cRepo.findAll();
	}
	public Product createProduct(Product product) {
		return this.pRepo.save(product);
	}
	public Category createCategory(Category category) {
		return this.cRepo.save(category);
	}
	public Association createAssociation(Association ass) {
		return this.aRepo.save(ass);
	}
	public List<Category> findCategoriesNotInProduct(Product product) {
		return cRepo.findByProductsNotContains(product);
	}
	public List<Product> findProductsNotInCategory(Category category) {
		return pRepo.findByCategoriesNotContains(category);
	}
}