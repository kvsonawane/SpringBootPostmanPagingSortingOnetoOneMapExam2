package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;



@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService applicantService;
	
	@PostMapping
	public Product createProduct(@RequestBody Product product)
	{
		return productService.save(product);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails)
	{
		Product updateProduct = productService.update(id, ProductDetails);
		
		return updateProduct != null ? ResponseEntity.ok(updateProduct) : ResponseEntity.notFound().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id)
	{
		Product product = productService.findById(id);
		
		return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
	}
	
	@GetMapping
	public Page<Product> getAllProducts(Pageable pageable)
	{
		return productService.findAll(pageable);
	}
	
	@GetMapping("/sorted")
	public List<Product> getAllProductsSorted(@RequestParam String sortBy,  @RequestParam String direction)
	{
		Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
		
		return productService.findAllSorted(sort);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id)
	{
		productService.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	

}
