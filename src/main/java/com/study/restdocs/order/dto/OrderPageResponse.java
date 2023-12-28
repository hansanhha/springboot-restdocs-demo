package com.study.restdocs.order.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.study.restdocs.order.entity.Order;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderPageResponse {

    public static OrderPageResponse from(Page<Order> orders) {
        return new OrderPageResponse(
                orders.stream()
                        .map(OrderResponse::from)
                        .toList(),
                orders.isFirst(),
                orders.isLast(),
                orders.hasNext(),
                orders.getSize());
    }

    @JsonProperty("orders")
    private final List<OrderResponse> orders;

    @JsonProperty("is_first")
    private final Boolean isFirst;

    @JsonProperty("is_last")
    private final Boolean isLast;

    @JsonProperty("has_next")
    private final Boolean hasNext;

    @JsonProperty("size")
    private final int size;
}
