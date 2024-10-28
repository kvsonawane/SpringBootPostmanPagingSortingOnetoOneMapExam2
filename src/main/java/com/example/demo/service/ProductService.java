package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;



public class ProductService {
	
	private ProductRepository applicantRepository;

    public Product save(Product product) { return productRepository.save(product); }

    public Product update(Long id, Product productDetails) {
        Product product = productRepository.findById(id).orElse(null);
        

}
