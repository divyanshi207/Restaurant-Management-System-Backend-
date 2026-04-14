package com.example.orders.exception;

public class ItemInCartWithIdNotFound extends RuntimeException{
    public ItemInCartWithIdNotFound(Long id){
        super("Item not found in cart with ID: "+id);
    }
}
