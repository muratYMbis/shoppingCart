package com.mbis.shoppingcart.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.mbis.shoppingcart.beans.Product;
import com.mbis.shoppingcart.beans.Category;
import com.mbis.shoppingcart.repository.CategoryRepository;

@RestController
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;

	//CREATE A NEW CATEGORY
	@PostMapping("/category/add")
	public void createCategory(@RequestBody Category category) {
		categoryRepository.save(category);
	}
	
	//GET ALL CATEGORIES
	@GetMapping("/category")
	public List<Category> getAllCategory(){
		return categoryRepository.findAll();
	}

	//GET PRODUCTS BY CATEGORY
	@GetMapping("category/{categoryId}")
	public List<Product> getProductsByCategoryId(@PathVariable int categoryId) {
		Optional<Category> category = categoryRepository.findById(categoryId);
		if(category.isEmpty()) {
			throw new RuntimeException("Category not found by with id "+categoryId);
		}
		return category.get().getProducts();
	}
}