package com.scalerecom.scalerecom.Services;

import com.scalerecom.scalerecom.Models.Category;
import com.scalerecom.scalerecom.Models.Product;
import com.scalerecom.scalerecom.exception.BadRequestException;
import com.scalerecom.scalerecom.exception.ProductNotFoundException;
import com.scalerecom.scalerecom.repository.CategoryRepository;
import com.scalerecom.scalerecom.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DBProductService implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private RedisTemplate redisTemplate;
    public DBProductService(ProductRepository productRepository, CategoryRepository categoryRepository, RedisTemplate redisTemplate) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.redisTemplate = redisTemplate;
    }


    @Override
    public Product getSingleProduct(long id) throws ProductNotFoundException {

        Product redisProduct = (Product) redisTemplate.opsForHash().get("PRODUCTS", "product" + id);
        if (redisProduct != null) {
            // cache hit
            return redisProduct;
        }

        Product product = productRepository.findById(id);
        if (product == null) {
            throw new ProductNotFoundException("product not found in database");
        }

        redisTemplate.opsForHash().put("PRODUCTS", "product" + id, product);
        return product;
    }
    //================================================================================


    //pagination for get all products
    @Override
    public Page<Product> getAllProducts(int pageNumber, int pageSize, String feildName) {
        Page<Product> products = productRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(feildName).ascending()));
        return products;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
    //====================================================================================
//    @Override
//    public List<Product> getAllProducts() {
//        List<Product> products = new ArrayList<>();
//        productRepository.findAll().forEach(products::add);
//        return products;
//    }
    //====================================================================================





    //====================================================================================
    @Override
    public Product createProduct( double price, String title, String description, String category, String imageUrl) throws BadRequestException {
        Product p = new Product();
        p.setPrice(price);
        p.setTitle(title);
        p.setDescription(description);
        Optional<Category> currCat = categoryRepository.findByCatTitle(category);
        if (currCat.isPresent()) {
            p.setCategory(currCat.get());
        }else {
            Category newCat = new Category();
            newCat.setCatTitle(category);
            categoryRepository.save(newCat);
            p.setCategory(newCat);
        }
        p.setImage_url(imageUrl);
        Product savedProduct = productRepository.save(p);
        return savedProduct;
    }
    //====================================================================================


    //====================================================================================
    @Override
    public ResponseEntity<String> deleteProduct(long id) {
        productRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public Product createProduct(long id, double price, String title, String description, String category, String imageUrl) throws BadRequestException {
        return null;
    }
    //====================================================================================


    //====================================================================================
    @Override
    public Product updateProduct(long id, double price, String title, String description, String category, String imageUrl) {
        Product p = new Product();
        p.setId(id);
        p.setPrice(price);
        p.setTitle(title);
        p.setDescription(description);
        p.setImage_url(imageUrl);

        Optional<Category> currCat = categoryRepository.findByCatTitle(category);
        if(currCat.isPresent()) {
            p.setCategory(currCat.get());
        }
        else{
            Category newCat = new Category();
            newCat.setCatTitle(category);
            categoryRepository.save(newCat);
            p.setCategory(newCat);
        }
        productRepository.save(p);
        return p;
    }
    //====================================================================================
}
