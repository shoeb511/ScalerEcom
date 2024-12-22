package com.scalerecom.scalerecom.Services;

import com.scalerecom.scalerecom.Models.Category;
import com.scalerecom.scalerecom.repository.CategoryRepository;
import com.scalerecom.scalerecom.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DBCategoryService implements CategoryService {
    CategoryRepository categoryRepository;
    ProductRepository productRepository;
    public DBCategoryService(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Category> getCategory(String name) {
        Optional<Category> category = categoryRepository.findByCatTitle(name);
        return category;
    }

    @Override
    public Optional<Category> createcategory(String categoryName) {
        Category newCategory = new Category();
        newCategory.setCatTitle(categoryName);
        categoryRepository.save(newCategory);
        return Optional.of(newCategory);
    }
}
