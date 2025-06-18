package com.fsse2410.parttimebackendproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProductNotExist extends RuntimeException {
    public ProductNotExist(String message) {
        super(message);
    }
}
