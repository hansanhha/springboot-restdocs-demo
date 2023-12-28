package com.study.restdocs.order.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderSaveRequest {

    @JsonProperty("user_id")
    private final String userId;

    @JsonProperty("price")
    private final Double price;

    @JsonProperty("quantity")
    private final int quantity;
}
