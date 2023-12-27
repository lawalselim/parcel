package com.example.parcel.service;

import com.example.parcel.model.Category;

import java.util.List;

public interface CategoryService {

    Category add(Category category);
    List<Category> getAll();
    List<Category> getByCategoryName(String categoryName);
}
