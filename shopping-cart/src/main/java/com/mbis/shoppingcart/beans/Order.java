package com.mbis.shoppingcart.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="checkout")
public class Order{

	@Id
	@GeneratedValue
	private long orderId;
	
	@OneToOne(fetch=FetchType.LAZY)
	private Cart cart;

	private String paymentMethod;
	private String deliveryMode;
	private String deliveryAddress;
	
	public Order() {
	}
	
	public Order(Cart cart, String paymentMethod, String deliveryMode, String deliveryAddress) {
		super();
		this.cart = cart;
		this.paymentMethod = paymentMethod;
		this.deliveryMode = deliveryMode;
		this.deliveryAddress = deliveryAddress;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getDeliveryMode() {
		return deliveryMode;
	}

	public void setDeliveryMode(String deliveryMode) {
		this.deliveryMode = deliveryMode;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

}