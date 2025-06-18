package com.fsse2410.parttimebackendproject.service;

import com.fsse2410.parttimebackendproject.domainObject.ProductResponseData;
import com.fsse2410.parttimebackendproject.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    List<ProductResponseData> getAllProduct();

    ProductResponseData getProductById(Integer id);

    ProductEntity getProductEntityById(Integer id);

    boolean deductStock(Integer pid, Integer quantity);
}
