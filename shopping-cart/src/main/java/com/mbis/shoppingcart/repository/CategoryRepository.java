package com.mbis.shoppingcart.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mbis.shoppingcart.beans.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
