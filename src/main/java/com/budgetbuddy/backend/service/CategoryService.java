package com.budgetbuddy.backend.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.budgetbuddy.backend.model.Category;
import com.budgetbuddy.backend.repository.CategoryRepository;

public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

}
