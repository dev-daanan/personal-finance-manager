package com.daanan.personalfinancemanager.service;

import com.daanan.personalfinancemanager.model.Category;
import com.daanan.personalfinancemanager.model.User;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories( );

    Category getCategoryById(Long categoryId);

    Category saveCategory(Category category);

    void deleteCategory(Long categoryId);

    List<Category> findByUser(User user);
}
