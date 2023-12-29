package hansanhha.spring.restdocs.order.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import hansanhha.spring.restdocs.order.entity.Order;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderSaveResponse {

    public static OrderSaveResponse create(Long orderId) {
        return new OrderSaveResponse(orderId);
    }

    @JsonProperty("order_id")
    private final Long orderId;

    public static OrderSaveResponse from(Order savedOrder) {
        return new OrderSaveResponse(savedOrder.getId());
    }
}
