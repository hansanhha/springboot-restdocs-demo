package com.study.restdocs.order.controller;

import com.study.restdocs.order.dto.OrderPageResponse;
import com.study.restdocs.order.dto.OrderResponse;
import com.study.restdocs.order.dto.OrderSaveRequest;
import com.study.restdocs.order.dto.OrderSaveResponse;
import com.study.restdocs.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping(path = "/orders")
    public ResponseEntity<OrderPageResponse> getAllOrders(Pageable pageable) {
        return ResponseEntity.ok().body(orderService.getOrders(pageable));
    }

    @GetMapping(path = "/orders/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(orderService.getOrderById(id));
    }

    @PostMapping(path = "/orders")
    public ResponseEntity<OrderSaveResponse> saveOrder(@RequestBody OrderSaveRequest orderSaveRequest) {
        OrderSaveResponse  orderSaveResponse = orderService.createOrder(orderSaveRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderSaveResponse);
    }

    @DeleteMapping(path = "/orders/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") Long id) {
        boolean deleted  = orderService.deleteOrder(id);
        return ResponseEntity.ok().body("Order deleted successfully, id : " + id);
    }

}
