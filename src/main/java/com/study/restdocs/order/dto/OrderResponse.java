package com.study.restdocs.order.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.study.restdocs.order.entity.Order;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderResponse {

    public static OrderResponse from(Order order) {
        return new OrderResponse(order.getId(), order.getBuyer(), order.getPrice());
    }

    @JsonProperty("order_id")
    private final Long id;

    @JsonProperty("user_id")
    private final String buyer;

    @JsonProperty("price")
    private final Double price;
}
