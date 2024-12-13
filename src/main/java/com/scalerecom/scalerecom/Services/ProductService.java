package com.scalerecom.scalerecom.Services;

import com.scalerecom.scalerecom.Models.Category;
import com.scalerecom.scalerecom.Models.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(long id);

    List<Product> getProducts();

    Product createProduct(long id, double price, String title, String description, String category, String imageUrl);

    void deleteProduct(long id);

}
