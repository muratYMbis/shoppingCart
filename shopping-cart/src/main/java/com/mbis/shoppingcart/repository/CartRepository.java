package com.mbis.shoppingcart.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mbis.shoppingcart.beans.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{

}
