package com.scalerecom.scalerecom.Controllers;

import com.scalerecom.scalerecom.Dto.FakeStoreProductDto;
import com.scalerecom.scalerecom.Models.Product;
import com.scalerecom.scalerecom.Services.FSProductService;
import com.scalerecom.scalerecom.Services.ProductService;
import com.scalerecom.scalerecom.exception.BadRequestException;
import com.scalerecom.scalerecom.exception.ProductNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FakestoreProductController {

    private FSProductService fsProductService;

    public FakestoreProductController(FSProductService fsProductService) {
        this.fsProductService = fsProductService;
    }

    @PostMapping("fsproduct")
    public Product createProduct(@RequestBody FakeStoreProductDto fakeStoreProductDto) throws BadRequestException {
        Product product = fsProductService.createProduct(fakeStoreProductDto.getId(), fakeStoreProductDto.getPrice(), fakeStoreProductDto.getTitle(), fakeStoreProductDto.getDescription(), fakeStoreProductDto.getCategory(), fakeStoreProductDto.getImage());
        return product;
    }

    @GetMapping("fsproducts")
    public List<Product> getAllProducts() {
        List<Product> products = fsProductService.getAllProducts();
        return products;
    }

    @GetMapping("fsproduct/{id}")
    public Optional<Product> getSingleProduct(@PathVariable int id) throws ProductNotFoundException {
        Optional<Product> product = fsProductService.getSingleProduct(id);
        return product;
    }

    @PutMapping("fsproduct")
    public Product updateProduct(@RequestBody FakeStoreProductDto fakeStoreProductDto) throws BadRequestException {
        Product product = fsProductService.updateProduct(fakeStoreProductDto.getId(), fakeStoreProductDto.getPrice(), fakeStoreProductDto.getTitle(), fakeStoreProductDto.getDescription(), fakeStoreProductDto.getCategory(), fakeStoreProductDto.getImage());
        return product;
    }

    @DeleteMapping("fsproduct/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) throws ProductNotFoundException {
        return fsProductService.deleteProduct(id);
    }


}
