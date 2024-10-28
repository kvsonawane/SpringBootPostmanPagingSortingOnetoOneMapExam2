package com.example.demo.service;

import com.example.demo.entity.Category;

import com.example.demo.repository.CategoryRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
	
	@Autowired
    private CategoryRepository categoryRepository;

    public Category save(Category category) { return categoryRepository.save(category); }

    public Category update(Long id, Category categoryDetails) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            category.setName(categoryDetails.getName());
       
            return categoryRepository.save(category);
        }
        return null;
    }

    public Category findById(Long id) { return categoryRepository.findById(id).orElse(null); }

    public void deleteById(Long id) { categoryRepository.deleteById(id); }

    public Page<Category> findAll(Pageable pageable) { return categoryRepository.findAll(pageable); }

    public List<Category> findAllSorted(Sort sort) { return categoryRepository.findAll(sort); }

}
