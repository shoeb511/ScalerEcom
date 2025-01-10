package com.scalerecom.scalerecom.Services;

import com.scalerecom.scalerecom.exception.BadRequestException;
import com.scalerecom.scalerecom.exception.ProductNotFoundException;
import com.scalerecom.scalerecom.Models.Product;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> getSingleProduct(long id) throws ProductNotFoundException;

    //Page<Product> getAllProducts(int pageNumber, int pageSize, String feildName);

    //pagination for get all products
    Page<Product> getAllProducts(int pageNumber, int pageSize, String feildName);

    List<Product> getAllProducts();

    Product createProduct(double price, String title, String description, String category, String imageUrl) throws BadRequestException;


    //List<Product> getAllProductsByCategoryId(long id);

    //Product createProduct(Product product);

    ResponseEntity<String> deleteProduct(long id);

    Product createProduct(long id, double price, String title, String description, String category, String imageUrl) throws BadRequestException;

    Product updateProduct(long id, double price, String title, String description, String category, String imageUrl);

}
