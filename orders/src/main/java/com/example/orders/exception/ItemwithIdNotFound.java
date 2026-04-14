package com.example.orders.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class ItemwithIdNotFound extends RuntimeException{
    public ItemwithIdNotFound(Long id){
        super("item not found with ID: "+id);
    }
}
