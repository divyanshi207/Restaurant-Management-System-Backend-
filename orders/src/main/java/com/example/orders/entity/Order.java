package com.example.orders.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    Long Bill;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBill() {
        return Bill;
    }

    public void setBill(Long bill) {
        Bill = bill;
    }

    public Order(Long id, String name, Long bill) {
        this.id = id;
        this.name = name;
        this.Bill = bill;
    }
}
