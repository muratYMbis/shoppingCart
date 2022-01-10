package com.mbis.shoppingcart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mbis.shoppingcart.beans.*;
import com.mbis.shoppingcart.repository.CartRepository;
import com.mbis.shoppingcart.repository.ProductRepository;



@RestController
public class CartController {
	
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private ProductRepository productRepository;
	
	//
	@GetMapping("/cart")
	public List<Cart> getAllCart(){
		return cartRepository.findAll();
	}
	
	//CREATE A NEW CART
	@PostMapping("/cart")
	public void createCart() {
		Cart cart = new Cart();
		cartRepository.save(cart);
	}
	
	//ADD TO CART
	@PutMapping("/cart")
	public void addToCart(@RequestParam int cartId, @RequestParam int productId, @RequestParam int quantity) {
		Cart cart;
		Optional<Cart> cartOpt = cartRepository.findById(cartId);
		if(cartOpt.isEmpty()) {
			cart = new Cart(1, null, null);}
		else {
			cart = cartOpt.get();}
		cart.addProduct(productRepository.findById(productId).get(), quantity);
		cart.setTotalPrice(cart.getTotalPrice() + productRepository.findById(productId).get().getPrice() * quantity);
		cartRepository.save(cart);
	}
}