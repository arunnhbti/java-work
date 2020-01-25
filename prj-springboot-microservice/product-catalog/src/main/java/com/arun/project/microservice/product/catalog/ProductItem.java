package com.arun.project.microservice.product.catalog;

public class ProductItem {
    private String id;
    private String name;

    ProductItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
