package com.fsse2410.parttimebackendproject.dto;

import com.fsse2410.parttimebackendproject.domainObject.ProductResponseData;

import java.math.BigDecimal;

public class ProductGetAllRepsonseDto {
    private Integer id;
    private String name;
    private String imageUrl;
    private BigDecimal price;
    private Boolean hasStock;

    public ProductGetAllRepsonseDto(ProductResponseData productResponseData) {
        this.id = productResponseData.getId();
        this.name = productResponseData.getName();
        this.imageUrl = productResponseData.getImageUrl();
        this.price = productResponseData.getPrice();
        this.hasStock = productResponseData.getStock() > 0;
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

    public Boolean getHasStock() {
        return hasStock;
    }

    public void setHasStock(Boolean hasStock) {
        this.hasStock = hasStock;
    }
}
