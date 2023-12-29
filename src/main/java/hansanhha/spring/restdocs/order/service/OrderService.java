package hansanhha.spring.restdocs.order.service;

import hansanhha.spring.restdocs.order.dto.OrderPageResponse;
import hansanhha.spring.restdocs.order.dto.OrderResponse;
import hansanhha.spring.restdocs.order.dto.OrderSaveRequest;
import hansanhha.spring.restdocs.order.dto.OrderSaveResponse;
import hansanhha.spring.restdocs.order.entity.Order;
import hansanhha.spring.restdocs.order.exception.OrderNotFoundException;
import hansanhha.spring.restdocs.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderPageResponse getOrders(Pageable pageable) {
        Page<Order> orderPage = orderRepository.findAll(pageable);
        return OrderPageResponse.from(orderPage);
    }

    public OrderResponse getOrderById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> OrderNotFoundException.create(id));

        return OrderResponse.from(order);
    }

    public boolean deleteOrder(Long id) {
        Optional<Order> orderOptional = orderRepository.findById(id);

        if (orderOptional.isEmpty()) {
            throw OrderNotFoundException.create(id);
        }

        orderRepository.delete(orderOptional.get());
        return false;
    }

    public OrderSaveResponse createOrder(OrderSaveRequest saveRequest) {
        Order order = toOrder(saveRequest);
        Order savedOrder = orderRepository.save(order);
        return OrderSaveResponse.from(savedOrder);
    }

    private Order toOrder(OrderSaveRequest saveRequest) {
        return Order.create(saveRequest.getUserId(), saveRequest.getPrice(), saveRequest.getQuantity());
    }

}
