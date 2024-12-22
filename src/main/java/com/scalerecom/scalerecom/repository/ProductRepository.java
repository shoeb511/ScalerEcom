package com.scalerecom.scalerecom.repository;

import com.scalerecom.scalerecom.Models.Category;
import com.scalerecom.scalerecom.Models.Product;
import com.scalerecom.scalerecom.repository.projections.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Save

    // Get

    // Get all

    // delete

    // update




    // This will insert product records in my product table
    Product save(Product product);

    // select * from product where title = title;
    Product findByTitle(String title);

    // Create a query like this "Select * from product where description = description;"
    Product findByDescription(String description);


     //Implement HQL
    @Query("select p from Product p where p.category.id =:categoryId")
    List<Product> getProductByCategoryId(@Param("categoryId") Long categoryId);

    // Implement NativeQuery
    @Query(value = "select * from product p where p.category_id =:categoryId", nativeQuery = true)
    List<Product> getProductByCategoryIdNativeQueries(@Param("categoryId") Long categoryId);


    @Query("select p.title as title, p.id as id from Product p where p.category.id =:categoryId")
    List<ProductProjection> getProductByCategoryIdUsingProjections(@Param("categoryId") Long categoryId);

}
