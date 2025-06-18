package com.fsse2410.parttimebackendproject.repository;

import com.fsse2410.parttimebackendproject.entity.TransactionEntity;
import com.fsse2410.parttimebackendproject.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<TransactionEntity, Integer> {
    TransactionEntity findTransactionEntityByTid(Integer tid);

    TransactionEntity findTransactionEntityByTidAndUserEntity(Integer tid, UserEntity userEntity);
}
