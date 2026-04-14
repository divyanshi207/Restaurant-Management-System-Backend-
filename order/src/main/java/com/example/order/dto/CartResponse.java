package com.example.order.dto;

import java.util.List;

public class CartResponse {
    private List<CartDTO> cartItems;
    private int currentPage;

    public List<CartDTO> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartDTO> cartItems) {
        this.cartItems = cartItems;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Long totalItems) {
        this.totalItems = totalItems;
    }

    private int totalPage;
    private Long totalItems;


}
