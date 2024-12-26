package com.scalerecom.scalerecom;

import com.scalerecom.scalerecom.Models.Product;
import com.scalerecom.scalerecom.repository.CategoryRepository;
import com.scalerecom.scalerecom.repository.ProductRepository;
import com.scalerecom.scalerecom.repository.projections.ProductProjection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ScalerEcomApplicationTests {

    @Test
    void contextLoads() {
    }

//    @Autowired
//    private ProductRepository productRepository;
//
//    @Autowired
//    private CategoryRepository categoryRepository;
//
//
//
//    @Test
//  public void querryTest(){
//        List<Product> products = productRepository.getProductByCatTitle("men's clothing");
//        System.out.println(products.size());
//        List<Product> products = productRepository.getProductByCategoryIdNativeQueries(2L);
//        //System.out.println(products.size());
//        for (Product product : products) {
//            System.out.println(product.getTitle());
//        }
//     }





}
