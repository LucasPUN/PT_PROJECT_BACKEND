package com.fsse2410.parttimebackendproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2410.parttimebackendproject.domainObject.CartItemResponseData;

import java.math.BigDecimal;

public class CartItemResponseDto {

    @JsonProperty("pid")
    private Integer pid;
    @JsonProperty("name")
    private String name;
    @JsonProperty("imageUrl")
    private String imageUrl;
    @JsonProperty("price")
    private BigDecimal price;
    @JsonProperty("cartQuantity")
    private Integer quantity;
    @JsonProperty("stock")
    private Integer stock;

    public CartItemResponseDto(CartItemResponseData cartItemResponseData) {
        this.pid = cartItemResponseData.getProductEntity().getId();
        this.name = cartItemResponseData.getProductEntity().getName();
        this.imageUrl = cartItemResponseData.getProductEntity().getImageUrl();
        this.price = cartItemResponseData.getProductEntity().getPrice();
        this.quantity = cartItemResponseData.getQuantity();
        this.stock = cartItemResponseData.getProductEntity().getStock();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
