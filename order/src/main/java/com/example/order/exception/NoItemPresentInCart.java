package com.example.order.exception;

public class NoItemPresentInCart extends RuntimeException {
    public NoItemPresentInCart(){
        super("No Item Present In Cart");
    }
}
