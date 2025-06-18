package com.fsse2410.parttimebackendproject.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "transaction_product")
public class TransactionProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tpid;

    @ManyToOne
    @JoinColumn(name = "tid", nullable = false)
    private TransactionEntity transaction;

    @Column(name = "pid", nullable = false)
    private Integer pid;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "image_Url", nullable = false)
    private String imageUrl;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "description")
    private String description;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    public TransactionProductEntity(TransactionEntity transactionEntity, CartItemEntity cartItemEntity) {
        this.transaction = transactionEntity;
        this.pid = cartItemEntity.getProduct().getId();
        this.name = cartItemEntity.getProduct().getName();
        this.imageUrl = cartItemEntity.getProduct().getImageUrl();
        this.price = cartItemEntity.getProduct().getPrice();
        this.description = cartItemEntity.getProduct().getDescription();
        this.stock = cartItemEntity.getProduct().getStock();
        this.quantity = cartItemEntity.getQuantity();
    }

    public TransactionProductEntity() {
    }

    public Integer getTpid() {
        return tpid;
    }

    public void setTpid(Integer tpid) {
        this.tpid = tpid;
    }

    public TransactionEntity getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionEntity transaction) {
        this.transaction = transaction;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
