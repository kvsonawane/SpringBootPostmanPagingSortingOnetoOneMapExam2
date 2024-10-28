package com.example.demo.controller;

import com.example.demo.entity.Category;

import com.example.demo.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
    private CategoryService categoryService;

    @PostMapping
    public Category createCategory(@RequestBody Category category) { return categoryService.save(category); }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category categoryDetails) {
        Category updatedCategory = categoryService.update(id, categoryDetails);
        return updatedCategory != null ? ResponseEntity.ok(updatedCategory) : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        return category != null ? ResponseEntity.ok(category) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public Page<Category> getAllCategories(Pageable pageable) 
    { 
    	return categoryService.findAll(pageable); 
    }

    @GetMapping("/sorted")
    public List<Category> getAllCategoriesSorted(@RequestParam String sortBy, @RequestParam String direction) 
    {
    	Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
		
		return categoryService.findAllSorted(sort);
        		
    }
    
    @DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable Long id)
	{
		categoryService.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}

}
