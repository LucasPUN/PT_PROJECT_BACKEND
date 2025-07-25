package com.fsse2410.parttimebackendproject.domainObject;

import com.fsse2410.parttimebackendproject.entity.TransactionEntity;
import com.fsse2410.parttimebackendproject.entity.TransactionProductEntity;
import com.fsse2410.parttimebackendproject.entity.UserEntity;
import com.fsse2410.parttimebackendproject.status.TransactionStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionResponseData {
    private Integer tid;
    private UserEntity user;
    private LocalDateTime transactionDate;
    private TransactionStatus transactionStatus;
    private BigDecimal amount;
    List<TransactionProductResponseData> transactionProductResponseDataList = new ArrayList<>();

    public TransactionResponseData(TransactionEntity transactionEntity) {
        this.tid = transactionEntity.getTid();
        this.user = transactionEntity.getUserEntity();
        this.transactionDate = transactionEntity.getDateTime();
        this.transactionStatus = transactionEntity.getStatus();
        this.amount = transactionEntity.getTotal();
        setTransactionProductResponseDataList(transactionEntity);
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public List<TransactionProductResponseData> getTransactionProductResponseDataList() {
        return transactionProductResponseDataList;
    }

    public void setTransactionProductResponseDataList(TransactionEntity transactionEntity) {
        for (TransactionProductEntity transactionProductEntity: transactionEntity.getTransactionProductEntityList()) {
            transactionProductResponseDataList.add(
                    new TransactionProductResponseData(transactionProductEntity)
            );
        }
    }
}
