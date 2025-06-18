package com.fsse2410.parttimebackendproject.dto;

import com.fsse2410.parttimebackendproject.domainObject.TransactionProductResponseData;

import java.math.BigDecimal;

public class TransactionProductResponseDto {
    private Integer tpid;
    private ProductByIdResponseDto product;
    private Integer quantity;
    private BigDecimal subtotal;

    public TransactionProductResponseDto(TransactionProductResponseData transactionProductResponseData) {
        this.product = new ProductByIdResponseDto(transactionProductResponseData);
        this.tpid = transactionProductResponseData.getTpid();
        this.quantity = transactionProductResponseData.getQuantity();
        this.subtotal = transactionProductResponseData.getPrice().multiply(
                new BigDecimal(
                    transactionProductResponseData.getQuantity()
                )
        );
    }

    public Integer getTpid() {
        return tpid;
    }

    public void setTpid(Integer tpid) {
        this.tpid = tpid;
    }

    public ProductByIdResponseDto getProduct() {
        return product;
    }

    public void setProduct(ProductByIdResponseDto product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}
