package com.caiodev.dsecommerce.dto;

import com.caiodev.dsecommerce.entities.Product;

public class ProductDto {
    private long id;
    private String name;
    private String description;
    private double price;
    private String imgUrl;

    public ProductDto(){
    }

    public ProductDto(long id, String name, String description, double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public ProductDto(Product entity) {
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();
        price = entity.getPrice();
        imgUrl = entity.getImgUrl();
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
