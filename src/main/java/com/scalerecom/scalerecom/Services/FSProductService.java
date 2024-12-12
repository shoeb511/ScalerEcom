package com.scalerecom.scalerecom.Services;

import com.scalerecom.scalerecom.Dto.FakeStoreProductDto;
import com.scalerecom.scalerecom.Models.Catagory;
import com.scalerecom.scalerecom.Models.Product;
import com.scalerecom.scalerecom.configs.AppConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FSProductService implements ProductService{

    private final RestTemplate restTemplate;

    public FSProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(long id) {
        System.out.println("inside the fsproductservice service");
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
        System.out.println(fakeStoreProductDto.toString());
        return fakeStoreProductDto.getProduct();
    }

    @Override
    public List<Product> getProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(long id, double price, String title, String description, Catagory catagory, String imageUrl) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(id);
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setCategory(catagory.getCatTitle());
        fakeStoreProductDto.setImage(imageUrl);
        fakeStoreProductDto.setPrice(price);

        FakeStoreProductDto response = restTemplate.patchForObject(
                "https://fakestoreapi.com/products",
                fakeStoreProductDto, FakeStoreProductDto.class
                );

        return response.getProduct();

    }

    @Override
    public void deleteProduct(long id) {
        System.out.println("inside the fsproductservice service's deleteProduct method");
        restTemplate.delete("https://fakestoreapi.com/products/" + id);
        System.out.println("now the product is deleted with id: " + id);
    }
}
