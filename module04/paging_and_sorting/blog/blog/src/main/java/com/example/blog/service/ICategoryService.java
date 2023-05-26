package com.example.blog.service;

import com.example.blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    void deleteCategory(Long id);
    void saveCategory(Category category);
    Category findById(Long categoryId);
}
