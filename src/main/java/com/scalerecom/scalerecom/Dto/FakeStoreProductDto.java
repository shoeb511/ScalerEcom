package com.scalerecom.scalerecom.Dto;

import com.scalerecom.scalerecom.Models.Category;
import com.scalerecom.scalerecom.Models.Product;
//import lombok.Getter;
//import lombok.Setter;

//@Getter
//@Setter
public class FakeStoreProductDto {
    private long id;
    private double price;
    private String title;
    private String description;
    private String category;
    private String image;


    public Product getProduct() {
        Product product = new Product();
        product.setProductId(id);
        product.setTitle(title);
        product.setPrice(price);
        product.setDescription(description);
        //product.setCategory(category);
        product.setImage_url(image);

        Category cat = new Category();

        cat.setCatTitle(category);
        product.setCategory(cat);

        return product;

    }

    @Override
    public String toString() {
        return "FakeStoreProductDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
