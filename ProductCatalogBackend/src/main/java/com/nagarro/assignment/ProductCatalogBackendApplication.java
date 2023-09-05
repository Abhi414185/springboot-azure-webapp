package com.nagarro.assignment;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nagarro.assignment.models.Product;
import com.nagarro.assignment.service.ProductService;
import com.nagarro.assignment.service.UserService;

@SpringBootApplication
public class ProductCatalogBackendApplication implements CommandLineRunner {
	
	@Autowired
	private ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(ProductCatalogBackendApplication.class, args);
	}
	
	@Override
	public void run(String...args) throws Exception {
		System.out.println("starting code");
		
	}

}
