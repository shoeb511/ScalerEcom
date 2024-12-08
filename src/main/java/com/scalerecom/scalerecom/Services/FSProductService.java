package com.scalerecom.scalerecom.Services;

import com.scalerecom.scalerecom.Models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FSProductService implements ProductService{

    @Override
    public Product getSingleProduct(long id) {
        return null;
    }

    @Override
    public List<Product> getProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }
}
