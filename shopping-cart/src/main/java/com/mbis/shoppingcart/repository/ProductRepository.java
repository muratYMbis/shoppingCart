package com.mbis.shoppingcart.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mbis.shoppingcart.beans.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
