package com.example.orders.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long cartId;
    Long itemId;
    String name;
    int price;

    public Cart() {
    }

    public Cart(Long cartId, Long itemId, String name, int price) {
        this.cartId = cartId;
        this.itemId = itemId;
        this.name = name;
        this.price = price;
    }

    public Long getCartId() {

        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
