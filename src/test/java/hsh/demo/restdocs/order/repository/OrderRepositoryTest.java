package hsh.demo.restdocs.order.repository;

import hsh.demo.restdocs.order.entity.Order;
import hsh.demo.restdocs.order.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


import static org.assertj.core.api.Assertions.*;


//@DataJpaTest
public class OrderRepositoryTest {

//    @Autowired
//    private OrderRepository orderRepository;
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
//    @Test
//    void getOrderList() {
//        orderRepository.saveAll(orders);
//
//        List<Order> orderList = orderRepository.findAll();
//
//        assertThat(orderList.size()).isEqualTo(10);
//        assertThat(orderList.getFirst().getBuyer()).isEqualTo("user-0");
//        assertThat(orderList.getFirst().getPrice()).isEqualTo(0.0);
//        assertThat(orderList.getFirst().getQuantity()).isEqualTo(0);
//    }
//
//    @Test
//    void getOrder() {
//        Order save = orderRepository.save(orders.getFirst());
//
//        Optional<Order> optionalOrder = orderRepository.findById(save.getId());
//
//        assertThat(optionalOrder.isPresent()).isTrue();
//
//        Order order = optionalOrder.get();
//
//        assertThat(order.getBuyer()).isEqualTo("user-0");
//        assertThat(order.getPrice()).isEqualTo(0.0);
//        assertThat(order.getQuantity()).isEqualTo(0);
//    }
//
//    @Test
//    void getInvalidOrder() throws Exception {
//        Optional<Order> optionalOrder = orderRepository.findById(1L);
//
//        assertThatThrownBy(optionalOrder::get).isInstanceOf(NoSuchElementException.class);
//        assertThat(optionalOrder.isPresent()).isFalse();
//    }
//
//    @Test
//    void saveOrder() {
//        Order order = orderRepository.save(orders.getFirst());
//
//        assertThat(order.getBuyer()).isEqualTo("user-0");
//        assertThat(order.getPrice()).isEqualTo(0.0);
//        assertThat(order.getQuantity()).isEqualTo(0);
//    }
//
//    @Test
//    void deleteOrder() {
//        Order order = orderRepository.save(orders.getFirst());
//
//        orderRepository.delete(order);
//
//        Optional<Order> optionalOrder = orderRepository.findById(order.getId());
//
//        assertThatThrownBy(optionalOrder::get).isInstanceOf(NoSuchElementException.class);
//        assertThat(optionalOrder.isPresent()).isFalse();
//    }

}
