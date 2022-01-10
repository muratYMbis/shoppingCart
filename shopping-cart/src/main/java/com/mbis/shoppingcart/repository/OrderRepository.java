package com.mbis.shoppingcart.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mbis.shoppingcart.beans.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
