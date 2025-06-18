package com.fsse2410.parttimebackendproject.domainObject;

import com.fsse2410.parttimebackendproject.entity.CartItemEntity;
import com.fsse2410.parttimebackendproject.entity.ProductEntity;
import com.fsse2410.parttimebackendproject.entity.UserEntity;

public class CartItemResponseData {
    private Integer cid;
    private ProductEntity productEntity;
    private UserEntity userEntity;
    private Integer quantity;

    public CartItemResponseData(CartItemEntity cartItemEntity) {
        this.cid = cartItemEntity.getCid();
        this.userEntity = cartItemEntity.getUser();
        this.productEntity = cartItemEntity.getProduct();
        this.quantity = cartItemEntity.getQuantity();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
