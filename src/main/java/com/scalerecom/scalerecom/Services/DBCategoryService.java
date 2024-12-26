package com.scalerecom.scalerecom.Services;

import com.scalerecom.scalerecom.Models.Category;
import com.scalerecom.scalerecom.repository.CategoryRepository;
import com.scalerecom.scalerecom.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public Optional<Category> getCategoryByName(String name) {
        System.out.println("this is the category you are searching for");
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

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        categoryRepository.findAll().forEach(category -> categories.add(category));
        return categories;
    }

    public Optional<Category> createCategory(String catTitle) {
        return null;
    }
}
