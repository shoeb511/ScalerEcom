package com.scalerecom.scalerecom.Services;

import com.scalerecom.scalerecom.Models.Category;
import com.scalerecom.scalerecom.Models.Product;
import com.scalerecom.scalerecom.exception.BadRequestException;
import com.scalerecom.scalerecom.exception.ProductNotFoundException;
import com.scalerecom.scalerecom.repository.CategoryRepository;
import com.scalerecom.scalerecom.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DBProductService implements ProductService {

    ProductRepository productRepository;
    CategoryRepository categoryRepository;
    public DBProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Optional<Product> getSingleProduct(long id) throws ProductNotFoundException {
        Optional<Product> product = productRepository.findById(id);
        if (product == null) {
            throw new ProductNotFoundException("product not found in database");
        }
        return product;
    }
    //====================================================================================
    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }
    //====================================================================================


    //====================================================================================
    @Override
    public Product createProduct( double price, String title, String description, String category, String imageUrl) throws BadRequestException {
        Product p = new Product();
        p.setPrice(price);
        p.setTitle(title);
        p.setDescription(description);
        Optional<Category> currCat = categoryRepository.findByCatTitle(category);
        if (currCat.isPresent()) {
            p.setCategory(currCat.get());
        }else {
            Category newCat = new Category();
            newCat.setCatTitle(category);
            categoryRepository.save(newCat);
            p.setCategory(newCat);
        }
        p.setImage_url(imageUrl);
        Product savedProduct = productRepository.save(p);
        return savedProduct;
    }
    //====================================================================================


    //====================================================================================
    @Override
    public ResponseEntity<String> deleteProduct(long id) {
        productRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
    //====================================================================================


    //====================================================================================
    @Override
    public Product updateProduct(long id, double price, String title, String description, String category, String imageUrl) {
        Product p = new Product();
        p.setId(id);
        p.setPrice(price);
        p.setTitle(title);
        p.setDescription(description);
        p.setImage_url(imageUrl);

        Optional<Category> currCat = categoryRepository.findByCatTitle(category);
        if(currCat.isPresent()) {
            p.setCategory(currCat.get());
        }
        else{
            Category newCat = new Category();
            newCat.setCatTitle(category);
            categoryRepository.save(newCat);
            p.setCategory(newCat);
        }
        productRepository.save(p);
        return p;
    }
    //====================================================================================
}
