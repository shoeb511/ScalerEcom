package com.scalerecom.scalerecom.Controllers;

import com.scalerecom.scalerecom.Models.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    // this controller will caontains the APIs around products, CRUD operations for the product
    // 1 api for create a product.
    // 2 for get the product
    // 3 for update a product
    // 4 for delete a product

    @RequestMapping(value = "create_product", method = RequestMethod.POST)
    public void create_product(long product_id) {

    }

    @RequestMapping(value = "getProduct", method = RequestMethod.GET)
    public Product get_product(long product_id) {
        return null;
    }

    @RequestMapping(value = "updateProduct", method = RequestMethod.POST)
    public void update_product( Product product) {

    }

    @RequestMapping(value = "deleteProduct", method = RequestMethod.DELETE)
    public void delete_product(long product_id) {

    }
}
