package com.scalerecom.scalerecom.Controllers;

import com.scalerecom.scalerecom.Dto.ErrorDto;
import com.scalerecom.scalerecom.exception.BadRequestException;
import com.scalerecom.scalerecom.exception.ProductNotFoundException;
import com.scalerecom.scalerecom.Models.Product;
//import com.scalerecom.scalerecom.Services.FSProductService;
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

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) throws BadRequestException {
        Product p = productService.createProduct(product.getProductId(),
         product.getPrice(), product.getTitle(), product.getDescription(),
         product.getCategory().getCatTitle(), product.getImage_url());

        ResponseEntity<Product> response = new ResponseEntity<>(p, HttpStatus.CREATED);
        return response;
    }

//

    @GetMapping("product/{id}")
    public ResponseEntity<Product> get_product(@PathVariable("id") long product_id) throws ProductNotFoundException {
        //System.out.println("Api of get_product is starting here");

        Product p = productService.getSingleProduct(product_id);
        //System.out.println("Api of get_product is ending here");

        ResponseEntity<Product> response = new ResponseEntity<>(p, HttpStatus.OK);
        return response;
    }

    @PatchMapping("updateProduct/")
    public ResponseEntity<Product> update_product(@RequestBody Product product) {
        System.out.println("Api of update _product is starting here");

        Product p = productService.updateProduct(
                product.getProductId(),
                product.getPrice(), product.getTitle(), product.getDescription(),
                product.getCategory().getCatTitle(), product.getImage_url()
        );

        ResponseEntity<Product> response = new ResponseEntity<>(p, HttpStatus.OK);

        System.out.println("Api of update _product is ending here");
        return response;
    }

    @DeleteMapping("deleteProduct/{id}")
    public ResponseEntity<String> delete_product(@PathVariable("id") long product_id) {
        System.out.println("Api of delete_product is starting here");
        productService.deleteProduct(product_id);
        System.out.println("Api of delete_product is ending here");
        ResponseEntity<String> response = new ResponseEntity<>("Product deleted", HttpStatus.ACCEPTED);
        return response;
    }

    @GetMapping("getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts() {

        productService.getAllProducts();

        ResponseEntity<List<Product>> response = new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);

        return response;
    }


    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorDto productNotFoundExceptionHandler(Exception e){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(e.getMessage());
        return errorDto;
    }

    @ExceptionHandler(BadRequestException.class)
    public ErrorDto badRequestExceptionHandler(Exception e){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(e.getMessage());
        return errorDto;
    }
}
