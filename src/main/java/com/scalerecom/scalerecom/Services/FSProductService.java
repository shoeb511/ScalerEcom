package com.scalerecom.scalerecom.Services;

import com.scalerecom.scalerecom.Dto.FakeStoreProductDto;
import com.scalerecom.scalerecom.exception.BadRequestException;
import com.scalerecom.scalerecom.exception.ProductNotFoundException;
import com.scalerecom.scalerecom.Models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FSProductService {


//    private final RestTemplate restTemplate;
//
//    public FSProductService(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//
//    @Override
//    public Product getSingleProduct(long id) throws ProductNotFoundException {
//        System.out.println("inside the fsproductservice service");
//        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
//
//        if(fakeStoreProductDto == null) {
//            throw new ProductNotFoundException("product not found");
//        }
//
//        System.out.println(fakeStoreProductDto.toString());
//        return fakeStoreProductDto.getProduct();
//    }
//
//
//
//    @Override
//    public Product createProduct(long id, double price, String title, String description, String category, String imageUrl) throws BadRequestException {
//        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
//        fakeStoreProductDto.setId(id);
//        fakeStoreProductDto.setTitle(title);
//        fakeStoreProductDto.setDescription(description);
//        fakeStoreProductDto.setCategory(category);
//        fakeStoreProductDto.setImage(imageUrl);
//        fakeStoreProductDto.setPrice(price);
//
//        FakeStoreProductDto response = restTemplate.postForObject(
//                "https://fakestoreapi.com/products",
//                fakeStoreProductDto, FakeStoreProductDto.class
//                );
//
//        return response.getProduct();
//
//    }
//
//    @Override
//    public void deleteProduct(long id) {
//        System.out.println("inside the fsproductservice service's deleteProduct method");
//        restTemplate.delete("https://fakestoreapi.com/products/" + id);
//        System.out.println("now the product is deleted with id: " + id);
//    }
//
//    @Override
//    public List<Product> getAllProducts() {
//
//        System.out.println("inside the fsproductservice service's getAllProducts method");
//
//        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject(
//                "https://fakestoreapi.com/products", FakeStoreProductDto[].class
//        );
//
//        List<Product> products = new ArrayList<>();
//        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
//            products.add(fakeStoreProductDto.getProduct());
//        }
//        return products;
////        Product[] products = new Product[fakeStoreProductDtos.length];
////        System.out.println("inside the fsproductservice service's getAllProducts method");
////        return products;
//    }
//
//    @Override
//    public Product updateProduct(long id, double price, String title, String description, String category, String imageUrl) {
//        System.out.println("inside the fsproductservice service's updateProduct method");
//        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
//        fakeStoreProductDto.setId(id);
//        fakeStoreProductDto.setTitle(title);
//        fakeStoreProductDto.setDescription(description);
//        fakeStoreProductDto.setCategory(category);
//        fakeStoreProductDto.setImage(imageUrl);
//        fakeStoreProductDto.setPrice(price);
//
//        FakeStoreProductDto response = restTemplate.patchForObject(
//                "https://fakestoreapi.com/products",
//                fakeStoreProductDto, FakeStoreProductDto.class
//        );
//        System.out.println("now the product is updated with id: " + id);
//        return response.getProduct();
//    }
    //return null;
}
