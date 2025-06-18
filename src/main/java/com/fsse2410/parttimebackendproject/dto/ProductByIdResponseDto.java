package com.fsse2410.parttimebackendproject.dto;

import com.fsse2410.parttimebackendproject.domainObject.ProductResponseData;
import com.fsse2410.parttimebackendproject.domainObject.TransactionProductResponseData;

import java.math.BigDecimal;

public class ProductByIdResponseDto {
    private Integer id;
    private String name;
    private String imageUrl;
    private BigDecimal price;
    private String description;
    private Integer stock;

    public ProductByIdResponseDto(ProductResponseData productResponseData) {
        this.id = productResponseData.getId();
        this.name = productResponseData.getName();
        this.imageUrl = productResponseData.getImageUrl();
        this.price = productResponseData.getPrice();
        this.description = productResponseData.getDescription();
        this.stock = productResponseData.getStock();
    }

    public ProductByIdResponseDto(TransactionProductResponseData transactionProductResponseData) {
        this.id = transactionProductResponseData.getPid();
        this.name = transactionProductResponseData.getName();
        this.imageUrl = transactionProductResponseData.getImageUrl();
        this.price = transactionProductResponseData.getPrice();
        this.description = transactionProductResponseData.getDescription();
        this.stock = transactionProductResponseData.getStock();
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
