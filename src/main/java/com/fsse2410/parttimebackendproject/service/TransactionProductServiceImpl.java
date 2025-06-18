package com.fsse2410.parttimebackendproject.service;

import com.fsse2410.parttimebackendproject.domainObject.FirebaseUserData;
import com.fsse2410.parttimebackendproject.domainObject.TransactionResponseData;
import com.fsse2410.parttimebackendproject.entity.CartItemEntity;
import com.fsse2410.parttimebackendproject.entity.TransactionEntity;
import com.fsse2410.parttimebackendproject.entity.TransactionProductEntity;
import com.fsse2410.parttimebackendproject.repository.TransactionProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionProductServiceImpl implements TransactionProductService {
    private CartItemService cartItemService;
    private TransactionProductRepository transactionProductRepository;

    @Autowired
    public TransactionProductServiceImpl(CartItemService cartItemService, TransactionProductRepository transactionProductRepository) {
        this.cartItemService = cartItemService;
        this.transactionProductRepository = transactionProductRepository;
    }

    @Override
    public List<TransactionProductEntity> createTransactionProductList(TransactionEntity transactionEntity){
        List<CartItemEntity> cartItemEntityList = cartItemService.getCartItemListByUserEntity(transactionEntity.getUserEntity());
        List<TransactionProductEntity> transactionProductEntities = new ArrayList<>();

        for (CartItemEntity cartItemEntity : cartItemEntityList) {
            TransactionProductEntity transactionProductEntity = new TransactionProductEntity(transactionEntity, cartItemEntity);
            transactionProductEntity = transactionProductRepository.save(transactionProductEntity);
            transactionProductEntities.add(transactionProductEntity);
        }
        return transactionProductEntities;
    }



}
