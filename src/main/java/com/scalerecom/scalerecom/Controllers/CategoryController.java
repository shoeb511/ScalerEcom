package com.scalerecom.scalerecom.Controllers;

import com.scalerecom.scalerecom.Models.Category;
import com.scalerecom.scalerecom.Services.DBCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {
    //CategoryController categoryController;
    DBCategoryService dbCategoryService;

    public CategoryController(DBCategoryService dbCategoryService) {
        //this.categoryController = categoryController;
        this.dbCategoryService = dbCategoryService;
    }

    //api for creating new entry in category table

    @PostMapping("category")
    public ResponseEntity<Optional<Category>> addCategory(@RequestBody Category category) {
        Optional<Category> cat = dbCategoryService.createCategory(category.getCatTitle());
        return new ResponseEntity<>(cat, HttpStatus.CREATED);
    }

//    @GetMapping("category/{title}")
//    public ResponseEntity<List<Category>> getAllCategories(@PathVariable("title") String catTitle) {
//        //dbCategoryService.getAllCategoriesByTitle(catTitle);
//        return new ResponseEntity<>(dbCategoryService.getAllCategoriesByTitle(catTitle), HttpStatus.OK);
//    }
}