package com.scalerecom.scalerecom.Services;

import com.scalerecom.scalerecom.Models.Category;

import java.util.Optional;

public interface CategoryService {

    Optional<Category> getCategory(String name);

    Optional<Category> createcategory(String categoryName);
}
