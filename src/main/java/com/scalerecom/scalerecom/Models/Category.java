package com.scalerecom.scalerecom.Models;

public class Category {
    private long catId;
    private String catTitle;

    public Category() {
    }

    public Category(long id, String name) {
        this.catId = id;
        this.catTitle = name;
    }

    public long getCatId() {
        return catId;
    }

    public void setCatId(long catId) {
        this.catId = catId;
    }

    public String getCatTitle() {
        return catTitle;
    }

    public void setCatTitle(String catTitle) {
        this.catTitle = catTitle;
    }
}
