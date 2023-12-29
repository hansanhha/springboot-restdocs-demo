package hansanhha.spring.restdocs.order.controller;

import hansanhha.spring.restdocs.order.dto.OrderPageResponse;
import hansanhha.spring.restdocs.order.dto.OrderResponse;
import hansanhha.spring.restdocs.order.dto.OrderSaveRequest;
import hansanhha.spring.restdocs.order.dto.OrderSaveResponse;
import hansanhha.spring.restdocs.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping(path = "/orders", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderPageResponse> getAllOrders(Pageable pageable) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(orderService.getOrders(pageable));
    }

    @GetMapping(path = "/orders/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(orderService.getOrderById(id));
    }

    @PostMapping(path = "/order", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderSaveResponse> saveOrder(@RequestBody OrderSaveRequest orderSaveRequest) {
        OrderSaveResponse  orderSaveResponse = orderService.createOrder(orderSaveRequest);
        return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(orderSaveResponse);
    }

    @DeleteMapping(path = "/orders/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("Order deleted successfully, id : " + id);
    }

}
