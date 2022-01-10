package com.mbis.shoppingcart.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mbis.shoppingcart.beans.Cart;
import com.mbis.shoppingcart.beans.Order;
import com.mbis.shoppingcart.repository.CartRepository;
import com.mbis.shoppingcart.repository.OrderRepository;


@RestController
public class OrderController {
	
	@Autowired
	private OrderRepository repository;
	@Autowired
	private CartRepository cartRepository;
	
	//GET ORDER
	@GetMapping("/order")
	public List<Order> getAllOrders(){
		return repository.findAll();
	}
	
	//CREATE AN ORDER
	@PostMapping("/order/{cartId}")
	public void createOrder(@PathVariable int cartId, 
			@RequestParam String paymentMethod, 
			@RequestParam String deliveryMode, 
			@RequestParam String deliveryAddress) {
		Cart cart = cartRepository.findById(cartId).get();
		Order order = new Order(cart, paymentMethod, deliveryMode, deliveryAddress);	
		repository.save(order);
	}
}