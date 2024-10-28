package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

    public Product save(Product product) { return productRepository.save(product); }

    public Product update(Long id, Product productDetails) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            product.setName(productDetails.getName());
            
            return productRepository.save(product);
        }
        return null;
    }

    public Product findById(Long id) { return productRepository.findById(id).orElse(null); }

    public void deleteById(Long id) { productRepository.deleteById(id); }

    public Page<Product> findAll(Pageable pageable) { return productRepository.findAll(pageable); }

    public List<Product> findAllSorted(Sort sort) { return productRepository.findAll(sort); }
        

}
