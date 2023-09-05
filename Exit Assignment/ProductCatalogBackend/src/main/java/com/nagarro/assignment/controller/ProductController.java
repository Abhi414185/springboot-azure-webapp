package com.nagarro.assignment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.assignment.models.Product;
import com.nagarro.assignment.repository.ProductRepository;
import com.nagarro.assignment.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@Autowired
	private ProductRepository repo;
	
	@GetMapping("/getproductlist")
	@CrossOrigin(origins="http://localhost:4200")
	public List<Product> fetchProductList(){
		List<Product>products=new ArrayList<Product>();
		
		//logic
		products=service.fetchproductList();
		return products;
	}
	
	@PostMapping("/addproduct")
	@CrossOrigin(origins="http://localhost:4200")
	public Product saveProduct(@RequestBody Product product) {
		
		return service.saveProductToDB(product);
		
	}
	
	@GetMapping("/getproductbyName/{name}")
	@CrossOrigin(origins="http://localhost:4200")
	public List<Product> fetchByName(@PathVariable String name){
		
		return repo.findByName(name);
		
	}
	
	@GetMapping("/getproductbyid/{id}")
	@CrossOrigin(origins="http://localhost:4200")
	public Product fetchProductByid(@PathVariable int id){
		
		return service.fetchProductById(id).get();
		
	}

}
