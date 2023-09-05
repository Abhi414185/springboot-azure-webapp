package com.nagarro.assignment.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.assignment.models.Product;
import com.nagarro.assignment.models.User;

public interface ProductRepository extends JpaRepository<Product,Integer> {
	
	List<Product> findByName(String name);
	

}
