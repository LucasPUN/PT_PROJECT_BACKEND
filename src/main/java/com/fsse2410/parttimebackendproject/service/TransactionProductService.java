package com.fsse2410.parttimebackendproject.service;

import com.fsse2410.parttimebackendproject.entity.TransactionEntity;
import com.fsse2410.parttimebackendproject.entity.TransactionProductEntity;

import java.util.List;

public interface TransactionProductService {
    List<TransactionProductEntity> createTransactionProductList(TransactionEntity transactionEntity);
}
