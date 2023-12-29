package hansanhha.spring.restdocs.order.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import hansanhha.spring.restdocs.order.dto.OrderPageResponse;
import hansanhha.spring.restdocs.order.dto.OrderResponse;
import hansanhha.spring.restdocs.order.dto.OrderSaveRequest;
import hansanhha.spring.restdocs.order.dto.OrderSaveResponse;
import hansanhha.spring.restdocs.order.entity.Order;
import hansanhha.spring.restdocs.order.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = {OrderController.class})
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;
    
    private Order order;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setup() {
        order = Order.create("test-user", 10.0,  40);
    }

    @Test
    void getOrderList() throws Exception {
        when(orderService.getOrders(PageRequest.of(0, 20)))
                .thenReturn(OrderPageResponse.from(new PageImpl<>(Collections.singletonList(order))));

        mockMvc.perform(get("/api/orders?page=0")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getOrder() throws Exception {
        when(orderService.getOrderById(1L))
                .thenReturn(OrderResponse.from(order));

        mockMvc.perform(get("/api/orders/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(result -> jsonPath("$.buyer", is("test-user")))
                .andExpect(result -> jsonPath("$.price", is(10.0)))
                .andExpect(result -> jsonPath("$.quantity", is(40)))
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    void createOrder() throws Exception {
        OrderSaveRequest orderSaveRequest = OrderSaveRequest.create(order.getBuyer(), order.getPrice(), order.getQuantity());

        when(orderService.createOrder(orderSaveRequest))
                .thenReturn(OrderSaveResponse.from(order));

        mockMvc.perform(
                        post("/api/order")
                                .content(objectMapper.writeValueAsString(orderSaveRequest))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void deleteOrder() throws Exception {
        when(orderService.deleteOrder(1L)).thenReturn(true);

        mockMvc.perform(delete("/api/orders/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

}