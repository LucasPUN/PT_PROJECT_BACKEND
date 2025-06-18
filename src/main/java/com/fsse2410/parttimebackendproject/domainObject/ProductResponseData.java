package com.fsse2410.parttimebackendproject.domainObject;

import com.fsse2410.parttimebackendproject.entity.ProductEntity;

import java.math.BigDecimal;

public class ProductResponseData {
    private Integer id;
    private String name;
    private String imageUrl;
    private BigDecimal price;
    private String description;
    private Integer stock;

    public ProductResponseData(ProductEntity productEntity) {
        this.id = productEntity.getId();
        this.name = productEntity.getName();
        this.imageUrl = productEntity.getImageUrl();
        this.price = productEntity.getPrice();
        this.description = productEntity.getDescription();
        this.stock = productEntity.getStock();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
