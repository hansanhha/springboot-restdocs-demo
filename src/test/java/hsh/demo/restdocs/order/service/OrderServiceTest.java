package hsh.demo.restdocs.order.service;

import hsh.demo.restdocs.order.dto.OrderPageResponse;
import hsh.demo.restdocs.order.dto.OrderResponse;
import hsh.demo.restdocs.order.dto.OrderSaveRequest;
import hsh.demo.restdocs.order.dto.OrderSaveResponse;
import hsh.demo.restdocs.order.entity.Order;
import hsh.demo.restdocs.order.exception.OrderNotFoundException;
import hsh.demo.restdocs.order.repository.OrderRepository;
import hsh.demo.restdocs.order.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

//@ExtendWith(SpringExtension.class)
public class OrderServiceTest {

//    @Mock
//    private OrderRepository orderRepository;
//
//    @InjectMocks
//    private OrderService orderService;
//
//    private final List<Order> orders = new ArrayList<>();
//
//    @BeforeEach
//    void setUp() {
//        for (int i = 0; i < 10; i++) {
//            Order order = Order.create("user-" + i, 1000.0 * i, i);
//            orders.add(order);
//        }
//    }
//
//
//    @Test
//    void getOrderList() {
//        when(orderRepository.findAll(PageRequest.of(0, 10)))
//                .thenReturn(new PageImpl<>(orders));
//
//        OrderPageResponse orderPageResponse = orderService.getOrders(PageRequest.of(0, 10));
//
//        assertThat(orderPageResponse.getOrders().size()).isEqualTo(10);
//        assertThat(orderPageResponse.getOrders().getFirst().getBuyer()).isEqualTo("user-0");
//        assertThat(orderPageResponse.getOrders().getFirst().getPrice()).isEqualTo(0.0);
//        assertThat(orderPageResponse.getOrders().getFirst().getQuantity()).isEqualTo(0);
//    }
//
//    @Test
//    void getOrder() {
//        when(orderRepository.findById(1L))
//                .thenReturn(Optional.of(orders.getFirst()));
//
//        OrderResponse orderResponse = orderService.getOrderById(1L);
//
//        assertThat(orderResponse.getBuyer()).isEqualTo("user-0");
//        assertThat(orderResponse.getPrice()).isEqualTo(0.0);
//        assertThat(orderResponse.getQuantity()).isEqualTo(0);
//    }
//
//    @Test
//    void getInValidOrder() {
//        when(orderRepository.findById(1L))
//                .thenReturn(Optional.empty());
//
//        assertThatThrownBy(() -> orderService.getOrderById(1L)).isInstanceOf(OrderNotFoundException.class);
//    }
//
//    @Test
//    void createOrder() {
//        Order order = orders.getFirst();
//
//        when(orderRepository.save(order))
//                .thenReturn(order);
//
//        OrderSaveResponse orderSaveResponse =
//                orderService.createOrder(OrderSaveRequest.create(order.getBuyer(), order.getPrice(), order.getQuantity()));
//
//        // verify() : 메서드 호출 동작 및 호출 횟수 검증
//        verify(orderRepository, times(1)).save(order);
//
//        // ArgumentCaptor : 메서드 호출 시 전달된 인자를 캡쳐하여 검증
//        ArgumentCaptor<Order> orderArgumentCaptor = ArgumentCaptor.forClass(Order.class);
//        verify(orderRepository).save(orderArgumentCaptor.capture());
//
//        Order createOrder = orderArgumentCaptor.getValue();
//        assertThat(createOrder).isEqualTo(order);
//
//        assertThat(orderSaveResponse.getBuyer()).isEqualTo(order.getBuyer());
//        assertThat(orderSaveResponse.getPrice()).isEqualTo(order.getPrice());
//        assertThat(orderSaveResponse.getQuantity()).isEqualTo(order.getQuantity());
//    }
//
//    @Test
//    void deleteOrder() throws Exception {
//        Order order = orders.getFirst();
//
//        when(orderRepository.findById(1L))
//                .thenReturn(Optional.of(order));
//
//        orderService.deleteOrder(1L);
//
//        verify(orderRepository, times(1)).delete(order);
//
//        ArgumentCaptor<Order> orderArgumentCaptor = ArgumentCaptor.forClass(Order.class);
//        verify(orderRepository).delete(orderArgumentCaptor.capture());
//
//        Order deleteOrder = orderArgumentCaptor.getValue();
//        assertThat(deleteOrder).isEqualTo(order);
//    }

}
