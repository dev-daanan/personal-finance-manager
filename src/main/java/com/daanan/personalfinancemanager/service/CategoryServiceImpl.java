package com.daanan.personalfinancemanager.service;

import com.daanan.personalfinancemanager.model.Category;
import com.daanan.personalfinancemanager.model.User;
import com.daanan.personalfinancemanager.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {

        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category saveCategory(Category category) {

        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories( ) {

        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long categoryId) {

        return categoryRepository.findById(categoryId)
                .orElseThrow(( ) -> new RuntimeException("Category not found for id: " + categoryId));
    }

    @Override
    public void deleteCategory(Long categoryId) {

        categoryRepository.deleteById(categoryId);
    }

    @Override
    public List<Category> findByUser(User user) {
        return categoryRepository.findByUser(user);
    }
}