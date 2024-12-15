package com.scalerecom.scalerecom.Controllers;

import com.scalerecom.scalerecom.Dto.ErrorDto;
import com.scalerecom.scalerecom.exception.BadRequestException;
import com.scalerecom.scalerecom.exception.ProductNotFoundException;
import com.scalerecom.scalerecom.Models.Product;
import com.scalerecom.scalerecom.Services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class ProductController {
    private final ProductService productService;
    // this controller will caontains the APIs around products, CRUD operations for the product
    // 1 api for create a product.
    // 2 for get the product
    // 3 for update a product
    // 4 for delete a product



    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //CREATE PRODUCT API
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) throws BadRequestException {
        Product p = productService.createProduct(product.getProductId(), product.getPrice(), product.getTitle(), product.getDescription(), product.getCategory().getCatTitle(), product.getImage_url());
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }
    //CREATE PRODUCT API


    //GET SINGLE PRODUCT API
    @GetMapping("product/{id}")
    public ResponseEntity<Product> get_product(@PathVariable("id") long product_id) throws ProductNotFoundException {
        Product p = productService.getSingleProduct(product_id);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
    //GET SINGLE PRODUCT API


    //UPDATE PRODUCT API
    @PatchMapping("updateProduct/")
    public ResponseEntity<Product> update_product(@RequestBody Product product) {
        Product p = productService.updateProduct(product.getProductId(), product.getPrice(), product.getTitle(), product.getDescription(), product.getCategory().getCatTitle(), product.getImage_url());
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
    //UPDATE PRODUCT API


    //DELETE PRODUCT API
    @DeleteMapping("deleteProduct/{id}")
    public ResponseEntity<String> delete_product(@PathVariable("id") long product_id) {
        productService.deleteProduct(product_id);
        return new ResponseEntity<>("Product deleted", HttpStatus.ACCEPTED);
    }
    //DELETE PRODUCT API


    //GET ALL PRODUCTS API
    @GetMapping("getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts() {
        productService.getAllProducts();
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }
    //GET ALL PRODUCTS API

// EXCEPTION HANDLING METHODS

    //PRODUCT NOT FOUND EXCEPTION
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorDto productNotFoundExceptionHandler(Exception e){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(e.getMessage());
        return errorDto;
    }
    //PRODUCT NOT FOUND EXCEPTIONS


    //BAD REQUEST EXCEPTION
    @ExceptionHandler(BadRequestException.class)
    public ErrorDto badRequestExceptionHandler(Exception e){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(e.getMessage());
        return errorDto;
    }
    //BAD REQUEST EXCEPTION
}
