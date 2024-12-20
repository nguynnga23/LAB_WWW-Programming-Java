package com.example.services;

import com.example.models.Category;

public interface CategoryService {
    void save(Category category);
    Category findById(Long id);
}
