package com.scalerecom.scalerecom.Controllers;

import com.scalerecom.scalerecom.Dto.ErrorDto;
import com.scalerecom.scalerecom.exception.BadRequestException;
import com.scalerecom.scalerecom.exception.ProductNotFoundException;
import com.scalerecom.scalerecom.Models.Product;
import com.scalerecom.scalerecom.Services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
public class DBProductController {
    private final ProductService productService;
    // this controller will caontains the APIs around products, CRUD operations for the product
    // 1 api for create a product.
    // 2 for get the product
    // 3 for update a product
    // 4 for delete a product



    public DBProductController(@Qualifier("DBProductService") ProductService productService) {
        this.productService = productService;
    }

    //CREATE PRODUCT API
    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) throws BadRequestException {
        Product p = productService.createProduct(product.getPrice(), product.getTitle(), product.getDescription(), product.getCategory().getCatTitle(), product.getImage_url());
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }
    //CREATE PRODUCT API


    //GET SINGLE PRODUCT API
    @GetMapping("product/{id}")
    public ResponseEntity<Optional<Product>> get_product(@PathVariable("id") long product_id) throws ProductNotFoundException {
        Optional<Product> p = productService.getSingleProduct(product_id);
        if(p.isPresent()) {
            return new ResponseEntity<>(p, HttpStatus.OK);
        }
        throw new ProductNotFoundException("Product with id " + product_id + " not found in the database");
    }
    //GET SINGLE PRODUCT API


    //UPDATE PRODUCT API
    @PatchMapping("product")
    public ResponseEntity<Product> update_product(@RequestBody Product product) {
        Product p = productService.updateProduct(product.getId(), product.getPrice(), product.getTitle(), product.getDescription(), product.getCategory().getCatTitle(), product.getImage_url());
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
    //UPDATE PRODUCT API


    //DELETE PRODUCT API
    @DeleteMapping("product/{id}")
    public ResponseEntity<String> delete_product(@PathVariable("id") long product_id) {
        return productService.deleteProduct(product_id);
        //return new ResponseEntity<>("Product deleted", HttpStatus.ACCEPTED);
    }
    //DELETE PRODUCT API


    //GET ALL PRODUCTS API
    @GetMapping("products")
    public ResponseEntity<List<Product>> getAllProducts() {
        productService.getAllProducts();
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }
    //GET ALL PRODUCTS API


    //CREATE ENTRIES IN CATEGORY TABLE
//    @PostMapping("category")
//    public ResponseEntity<Category> createCategory(@RequestBody Category category) throws BadRequestException {
//
//    }



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
