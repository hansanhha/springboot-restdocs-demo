package com.study.restdocs.order.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    public static Order create(String buyer, Double price, int quantity) {
        Order order = new Order();
        order.buyer = buyer;
        order.price = price;
        order.quantity = quantity;
        return order;
    }

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    String buyer;

    Double price;

    int quantity;

}
