package com.example.order.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TOTAL_ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Long Bill;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBill() {
        return Bill;
    }

    public void setBill(Long bill) {
        Bill = bill;
    }

    public Order(Long id, Long bill) {
        this.id = id;
        this.Bill = bill;
    }
}
