package hsh.demo.restdocs.order.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import hsh.demo.restdocs.order.entity.Order;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderResponse {

    public static OrderResponse create(Long id, String buyer, Double price, int quantity) {
        return new OrderResponse(id, buyer, price, quantity);
    }

    public static OrderResponse from(Order order) {
        return new OrderResponse(order.getId(), order.getBuyer(), order.getPrice(), order.getQuantity());
    }

    @JsonProperty("order_id")
    private final Long id;

    @JsonProperty("buyer")
    private final String buyer;

    @JsonProperty("price")
    private final Double price;

    @JsonProperty("quantity")
    private final int quantity;
}
