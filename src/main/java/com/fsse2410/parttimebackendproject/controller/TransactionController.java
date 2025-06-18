package com.fsse2410.parttimebackendproject.controller;


import com.fsse2410.parttimebackendproject.dto.TransactionResponseDto;
import com.fsse2410.parttimebackendproject.service.TransactionService;
import com.fsse2410.parttimebackendproject.utill.JwtUtill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transactions")
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("")
    public TransactionResponseDto createTransaction(
            JwtAuthenticationToken jwtAuthenticationToken) {
        return new TransactionResponseDto(transactionService.prepareTransaction(
                JwtUtill.getFirebaseUserData(jwtAuthenticationToken)));
    }

    @GetMapping("/{tid}")
    public TransactionResponseDto getTransaction(
            JwtAuthenticationToken jwtAuthenticationToken,
            @PathVariable Integer tid) {
        return new TransactionResponseDto(
                transactionService.getTransactionByTid(
                        JwtUtill.getFirebaseUserData(jwtAuthenticationToken),
                        tid));
    }

    @PatchMapping("/{tid}/payment")
    public void payTransaction(JwtAuthenticationToken jwtAuthenticationToken,
            @PathVariable Integer tid) {
        transactionService.processTransaction(
                JwtUtill.getFirebaseUserData(jwtAuthenticationToken), tid);
    }

    @PatchMapping("/{tid}/success")
    public TransactionResponseDto finishTransaction(
            JwtAuthenticationToken jwtAuthenticationToken,
            @PathVariable Integer tid) {
        return new TransactionResponseDto(transactionService.finishTransaction(
                JwtUtill.getFirebaseUserData(jwtAuthenticationToken), tid));
    };
}
