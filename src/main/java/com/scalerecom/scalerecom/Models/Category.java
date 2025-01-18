package com.scalerecom.scalerecom.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;

@Entity
public class Category extends BaseModel{
    private String catTitle;
    public Category() {
    }


    @OneToMany (mappedBy = "category", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Product> products;

    public Category(long id, String name) {
        this.id = id;
        this.catTitle = name;
    }

    public String getCatTitle() {
        return catTitle;
    }

    public void setCatTitle(String catTitle) {
        this.catTitle = catTitle;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
