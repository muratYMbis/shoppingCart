package com.mbis.shoppingcart.beans;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Cart {

	@Id
	@GeneratedValue
	private int cartId;

	@ElementCollection
	private List<Product> products;
	@ElementCollection
	private List<Integer> quantity;
	
	private double totalPrice;
	
	@OneToOne(fetch=FetchType.LAZY)
	private Order order;
	
	public Cart() {	
	}

	public Cart(int cartId, List<Product> products, List<Integer> quantity) {
		super();
		this.cartId = cartId;
		this.products = products;
		this.quantity = quantity;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Integer> getQuantity() {
		return quantity;
	}

	public void setQuantity(List<Integer> quantity) {
		this.quantity = quantity;
	}
	
	public void addProduct(Product product, int quantity) {
		this.products.add(product);
		this.quantity.add(quantity);
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}