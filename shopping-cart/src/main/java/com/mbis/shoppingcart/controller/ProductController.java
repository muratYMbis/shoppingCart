package com.mbis.shoppingcart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mbis.shoppingcart.beans.Product;
import com.mbis.shoppingcart.repository.ProductRepository;
import com.mbis.shoppingcart.repository.CategoryRepository;

@RestController
public class ProductController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	
	//GET ALL PRODUCTS
	@GetMapping("/product")
	public List<Product> getProducts(){
		return productRepository.findAll();
	}

	//CREATE A NEW PRODUCT
	@PostMapping("/product/add")
	public void createProduct(@RequestParam(value= "categoryId") int categoryId, @RequestBody Product product) {
		product.setCategory(categoryRepository.findById(categoryId).get());
		productRepository.save(product);
	}
	
	//GET PRODUCT DETAILS
	@GetMapping("/product/{productId}")
	public Product getProductDetails(@PathVariable int productId){
		Optional<Product> product = productRepository.findById(productId);
		if(product.isEmpty()) {
			throw new RuntimeException("Category not found by with id "+productId);
		}
		return product.get();
	}
}