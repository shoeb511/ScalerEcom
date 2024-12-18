package com.scalerecom.scalerecom.Models;

import jakarta.persistence.Entity;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
public class Category extends BaseModel{
    private String catTitle;
    public Category() {
    }

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
}
