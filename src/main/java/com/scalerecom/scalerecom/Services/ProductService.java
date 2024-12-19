package com.scalerecom.scalerecom.Services;

import com.scalerecom.scalerecom.exception.BadRequestException;
import com.scalerecom.scalerecom.exception.ProductNotFoundException;
import com.scalerecom.scalerecom.Models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> getSingleProduct(long id) throws ProductNotFoundException;

    List<Product> getAllProducts();

    Product createProduct(double price, String title, String description, String category, String imageUrl) throws BadRequestException;

    //List<Product> getAllProductsByCategoryId(long id);

    //Product createProduct(Product product);

    void deleteProduct(long id);

    Product updateProduct(long id, double price, String title, String description, String category, String imageUrl);

}
