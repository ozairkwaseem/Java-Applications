package com.ozair.javaspringbasics.ProductCategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ozair.javaspringbasics.ProductCategories.models.Association;
import com.ozair.javaspringbasics.ProductCategories.models.Category;
import com.ozair.javaspringbasics.ProductCategories.models.Product;
import com.ozair.javaspringbasics.ProductCategories.services.AppService;

@Controller
public class ProductController {
	private AppService appService;
	public ProductController(AppService service) {
		this.appService = service;
	}
	@GetMapping("/")
	public String Index(Model model) {
		model.addAttribute("products", appService.findProducts());
		return "products/index.jsp";
	}
	@GetMapping("/products/newproduct")
	public String newprod(Model model) {
		model.addAttribute("newproduct", new Product());
		return "products/newproduct.jsp";
	}
	@PostMapping("/products/createproduct")
	public String createprod(@Valid @ModelAttribute("newproduct") Product newProduct, BindingResult result, Model model) {
		appService.createProduct(newProduct);
		return "redirect:/";
	}
	@GetMapping("/categories/category")
	public String categories(Model model) {
		model.addAttribute("categories", appService.findCategories());
		return "categories/categoriesindex.jsp";
		}
		
	@GetMapping("/categories/newcategory")
	public String newcat(Model model) {
		model.addAttribute("newcategory", new Category());
		return "categories/newcategory.jsp";
	}
	@PostMapping("/categories/createcategory")
	public String createcat(@Valid @ModelAttribute("newcategory") Category newCategory, BindingResult result, Model model) {
		appService.createCategory(newCategory);
		return "redirect:/";
	}
	
	
	@GetMapping("/{id}")
	public String Show(@ModelAttribute("association") Association association, 
		@PathVariable("id") Long id, Model model) {
		Product thisOne = appService.getProduct(id);
		List<Category> others = appService.findCategoriesNotInProduct(thisOne);
		model.addAttribute("product", thisOne);
		model.addAttribute("notInCategories", others);
		return "products/show.jsp";
	}
}