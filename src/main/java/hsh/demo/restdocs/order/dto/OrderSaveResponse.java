package hsh.demo.restdocs.order.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import hsh.demo.restdocs.order.entity.Order;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderSaveResponse {

    @JsonProperty("order_id")
    private final Long orderId;

    @JsonProperty("buyer")
    private final String buyer;

    @JsonProperty("price")
    private final Double price;

    @JsonProperty("quantity")
    private final int quantity;

    public static OrderSaveResponse from(Order savedOrder) {
        return new OrderSaveResponse(savedOrder.getId(), savedOrder.getBuyer(), savedOrder.getPrice(), savedOrder.getQuantity());
    }
}
