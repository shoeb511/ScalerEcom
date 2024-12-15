package com.scalerecom.scalerecom.Services;

import com.scalerecom.scalerecom.exception.BadRequestException;
import com.scalerecom.scalerecom.exception.ProductNotFoundException;
import com.scalerecom.scalerecom.Models.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(long id) throws ProductNotFoundException;

    List<Product> getAllProducts();

    Product createProduct(long id, double price, String title, String description, String category, String imageUrl) throws BadRequestException;

    void deleteProduct(long id);

    Product updateProduct(long id, double price, String title, String description, String category, String imageUrl);

}
