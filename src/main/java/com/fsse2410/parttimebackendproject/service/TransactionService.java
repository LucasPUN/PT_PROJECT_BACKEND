package com.fsse2410.parttimebackendproject.service;

import com.fsse2410.parttimebackendproject.domainObject.FirebaseUserData;
import com.fsse2410.parttimebackendproject.domainObject.TransactionResponseData;

public interface TransactionService {
    TransactionResponseData prepareTransaction(FirebaseUserData firebaseUserData);

    TransactionResponseData getTransactionByTid(FirebaseUserData firebaseUserData, Integer tid);

    void processTransaction(FirebaseUserData firebaseUserData, Integer tid);

    TransactionResponseData finishTransaction(FirebaseUserData firebaseUserData, Integer tid);
}
