package com.scalerecom.scalerecom.Services;

import com.scalerecom.scalerecom.Dto.FakeStoreProductDto;
import com.scalerecom.scalerecom.exception.BadRequestException;
import com.scalerecom.scalerecom.exception.ProductNotFoundException;
import com.scalerecom.scalerecom.Models.Product;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FSProductService implements ProductService{


    private final RestTemplate fsrestTemplate;

    public FSProductService(RestTemplate fsrestTemplate) {
        this.fsrestTemplate = fsrestTemplate;
    }

    @Override
    public Optional<Product> getSingleProduct(long id) throws ProductNotFoundException {
        System.out.println("inside the fsproductservice service");
        FakeStoreProductDto fakeStoreProductDto = fsrestTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);

        if(fakeStoreProductDto == null) {
            throw new ProductNotFoundException("product not found");
        }

        System.out.println(fakeStoreProductDto.toString());
        Optional<Product> product = Optional.of(fakeStoreProductDto.getProduct());
        return product;
    }

    @Override
    public Page<Product> getAllProducts(int pageNumber, int pageSize, String feildName) {
        return null;
    }


    @Override
    public ResponseEntity<String> deleteProduct(long id) {
        System.out.println("inside the fsproductservice service's deleteProduct method");
        fsrestTemplate.delete("https://fakestoreapi.com/products/" + id);
        System.out.println("now the product is deleted with id: " + id);
        return ResponseEntity.ok().build();
    }

    @Override
    public List<Product> getAllProducts() {

        System.out.println("inside the fsproductservice service's getAllProducts method");

        FakeStoreProductDto[] fakeStoreProductDtos = fsrestTemplate.getForObject(
                "https://fakestoreapi.com/products", FakeStoreProductDto[].class
        );

        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            products.add(fakeStoreProductDto.getProduct());
        }
        return products;

    }

    @Override
    public Product createProduct(double price, String title, String description, String category, String imageUrl) throws BadRequestException {
        return null;
    }


    @Override
    public Product createProduct(long id, double price, String title, String description, String category, String imageUrl)  {
        System.out.println("inside the fsproductservice service's createProduct method");
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(id);
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setImage(imageUrl);
        fakeStoreProductDto.setPrice(price);

        FakeStoreProductDto response = fsrestTemplate.postForObject(
                "https://fakestoreapi.com/products",
                fakeStoreProductDto, FakeStoreProductDto.class
        );
        System.out.println("now the product is created with id: " + id);
        return response.getProduct();
    }



    @Override
    public Product updateProduct(long id, double price, String title, String description, String category, String imageUrl) {
        System.out.println("inside the fsproductservice service's updateProduct method");
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();

        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setImage(imageUrl);
        fakeStoreProductDto.setPrice(price);

        fsrestTemplate.put("https://fakestoreapi.com/products/" + id, fakeStoreProductDto);
        System.out.println("Printing new values");
        System.out.println(fakeStoreProductDto.toString());
        return fakeStoreProductDto.getProduct();
    }

}
