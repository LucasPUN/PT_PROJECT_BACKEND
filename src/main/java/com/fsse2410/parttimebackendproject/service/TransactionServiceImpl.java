package com.fsse2410.parttimebackendproject.service;

import com.fsse2410.parttimebackendproject.domainObject.FirebaseUserData;
import com.fsse2410.parttimebackendproject.domainObject.TransactionResponseData;
import com.fsse2410.parttimebackendproject.entity.TransactionEntity;
import com.fsse2410.parttimebackendproject.entity.TransactionProductEntity;
import com.fsse2410.parttimebackendproject.entity.UserEntity;
import com.fsse2410.parttimebackendproject.repository.TransactionRepository;
import com.fsse2410.parttimebackendproject.status.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private UserService userService;
    private TransactionRepository transactionRepository;
    private TransactionProductService transactionProductService;
    private ProductService productService;
    private CartItemService cartItemService;

    @Autowired
    public TransactionServiceImpl(UserService userService, TransactionRepository transactionRepository, TransactionProductService transactionProductService, ProductService productService, CartItemService cartItemService) {
        this.userService = userService;
        this.transactionRepository = transactionRepository;
        this.transactionProductService = transactionProductService;
        this.productService = productService;
        this.cartItemService = cartItemService;
    }

    @Override
    public TransactionResponseData prepareTransaction(FirebaseUserData firebaseUserData){
        UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);

        TransactionEntity transactionEntity = new TransactionEntity(userEntity);
        transactionEntity = transactionRepository.save(transactionEntity);

        List<TransactionProductEntity> transactionProductEntityList = transactionProductService.createTransactionProductList(transactionEntity);
        transactionEntity.setTransactionProductEntityList(transactionProductEntityList);

        transactionEntity.setTotal(
                getTotal(transactionEntity.getTransactionProductEntityList())
        );

        transactionEntity = transactionRepository.save(transactionEntity);

        TransactionResponseData transactionResponseData = new TransactionResponseData(transactionEntity);
        return transactionResponseData;
    }

    @Override
    public TransactionResponseData getTransactionByTid(FirebaseUserData firebaseUserData, Integer tid){
        UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);

        TransactionEntity transactionEntity = transactionRepository.findTransactionEntityByTid(tid);

        if (!transactionEntity.getUserEntity().getUid().equals(userEntity.getUid())){
            throw new RuntimeException();
        }

        return new TransactionResponseData(transactionEntity);
    }


    @Override
    public void processTransaction(FirebaseUserData firebaseUserData, Integer tid) {

        UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);

        TransactionEntity transactionEntity = transactionRepository.findTransactionEntityByTidAndUserEntity(
                tid, userEntity
        );

        if (transactionEntity.getStatus() != TransactionStatus.PREPARE) {
            throw new RuntimeException();
        }

        transactionEntity.setStatus(TransactionStatus.PROCESSING);
        transactionRepository.save(transactionEntity);
    }

    @Override
    public TransactionResponseData finishTransaction(FirebaseUserData firebaseUserData, Integer tid){
        UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);

        TransactionEntity transactionEntity = transactionRepository.findTransactionEntityByTidAndUserEntity(
                tid, userEntity
        );

        if (transactionEntity.getStatus() != TransactionStatus.PROCESSING) {
            throw new RuntimeException();
        }

        for(TransactionProductEntity transactionProductEntity:transactionEntity.getTransactionProductEntityList()){
            productService.deductStock(transactionProductEntity.getPid(), transactionProductEntity.getQuantity());
        }

        cartItemService.emptyCart(userEntity);

        transactionEntity.setStatus(TransactionStatus.SUCCESS);
        transactionRepository.save(transactionEntity);
        return new TransactionResponseData(transactionEntity);

    }

    public BigDecimal getTotal(List<TransactionProductEntity> transactionProductEntityList){
        BigDecimal total = BigDecimal.ZERO;
        for(TransactionProductEntity transactionProductEntity : transactionProductEntityList){
            BigDecimal price = transactionProductEntity.getPrice();
            Integer quantity = transactionProductEntity.getQuantity();
            total = total.add(price.multiply(BigDecimal.valueOf(quantity)));
        }
        return total;
    }
}
