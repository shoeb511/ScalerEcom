package com.scalerecom.scalerecom.Services;

import com.scalerecom.scalerecom.Models.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(long id);

    List<Product> getProducts();

    Product createProduct(Product product);

}
