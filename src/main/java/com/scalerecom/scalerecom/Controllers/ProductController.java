package com.scalerecom.scalerecom.Controllers;

import com.scalerecom.scalerecom.Models.Product;
//import com.scalerecom.scalerecom.Services.FSProductService;
import com.scalerecom.scalerecom.Services.ProductService;
import org.springframework.web.bind.annotation.*;

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
    public Product createProduct(@RequestBody Product product) {
        Product p = productService.createProduct(product.getProductId(),
                product.getPrice(), product.getTitle(), product.getDescription(),
                product.getCategory().getCatTitle(), product.getImage_url());
        return p;
    }


    @GetMapping("/product/{id}")
    public Product get_product(@PathVariable("id") long product_id) {
        System.out.println("Api of get_product is starting here");
        Product p = productService.getSingleProduct(product_id);
        System.out.println("Api of get_product is ending here");
        return p;
    }

    @RequestMapping(value = "updateProduct", method = RequestMethod.POST)
    public void update_product( Product product) {

    }

    @DeleteMapping("deleteProduct/{id}")
    public String delete_product(@PathVariable("id") long product_id) {
        System.out.println("Api of delete_product is starting here");
        productService.deleteProduct(product_id);
        System.out.println("Api of delete_product is ending here");
        return "Product deleted with id: " + product_id;
    }
}
