package com.fsse2410.parttimebackendproject.service;

import com.fsse2410.parttimebackendproject.domainObject.ProductResponseData;
import com.fsse2410.parttimebackendproject.entity.ProductEntity;
import com.fsse2410.parttimebackendproject.exception.ProductNotExist;
import com.fsse2410.parttimebackendproject.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductResponseData> getAllProduct(){
        List<ProductResponseData> productResponseDataList = new ArrayList<>();

        for(ProductEntity productEntity : productRepository.findAll()){
            productResponseDataList.add(
                    new ProductResponseData(productEntity)
            );
        }
        return productResponseDataList;
    }

    @Override
    public ProductResponseData getProductById(Integer id){
        if(productRepository.findById(id).isPresent()){
            return new ProductResponseData(
                    productRepository.findById(id).get()
            );
        };
        throw new ProductNotExist("Product Not Exist");
    }


    @Override
    public ProductEntity getProductEntityById(Integer id){
        if(productRepository.findById(id).isPresent()){
            return productRepository.findById(id).get();
        };
        throw new ProductNotExist("Product Not Exist");
    }


    @Override
    public boolean deductStock(Integer pid, Integer quantity){
        ProductEntity productEntity = productRepository.findById(pid).orElseThrow(() ->new RuntimeException());

        if(productEntity.getStock() < quantity){
            throw new RuntimeException();
        }

        productEntity.setStock(productEntity.getStock() - quantity);
        productRepository.save(productEntity);
        return true;
    }
}
