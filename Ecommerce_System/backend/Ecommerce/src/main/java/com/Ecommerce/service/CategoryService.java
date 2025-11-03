package com.Ecommerce.service;

import com.Ecommerce.model.Category;
import com.Ecommerce.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Integer id) {
        return categoryRepository.findById(id);
    }

    public Category updateCategory(Integer id, Category updatedCategory) {
        return categoryRepository.findById(id).map(category -> {
            category.setCategoryName(updatedCategory.getCategoryName());
            category.setDescription(updatedCategory.getDescription());
            category.setStatus(updatedCategory.getStatus());
            return categoryRepository.save(category);
        }).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public void deleteCategory(Integer id) {
        categoryRepository.findById(id).ifPresent(category -> {
            category.setStatus(false); // Soft delete
            categoryRepository.save(category);
        });
    }
}
