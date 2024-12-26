package com.scalerecom.scalerecom.Services;

import com.scalerecom.scalerecom.Models.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Optional<Category> getCategoryByName(String name);

    Optional<Category> createcategory(String categoryName);

    List<Category> getAllCategories();
}
