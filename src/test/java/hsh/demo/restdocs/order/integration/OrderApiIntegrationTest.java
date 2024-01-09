package hsh.demo.restdocs.order.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import hsh.demo.restdocs.order.dto.OrderPageResponse;
import hsh.demo.restdocs.order.dto.OrderResponse;
import hsh.demo.restdocs.order.dto.OrderSaveRequest;
import hsh.demo.restdocs.order.dto.OrderSaveResponse;
import hsh.demo.restdocs.order.repository.OrderRepository;
import hsh.demo.restdocs.order.service.OrderService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.*;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.assertThat;

//@Sql(statements = "DELETE FROM orders WHERE buyer LIKE 'dummy-user%'",
//        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderApiIntegrationTest {

//    @LocalServerPort
//    private int port;
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    private OrderService orderService;
//
//    @Autowired
//    private OrderRepository orderRepository;
//
//    private final static HttpHeaders header = new HttpHeaders();
//
//    private final ObjectMapper mapper = new ObjectMapper();
//
//    @BeforeAll
//    static void setUp() {
//        header.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
//    }
//
//    @BeforeEach
//    void insertDummy() {
//        for(int i = 1; i <= 10; i++) {
//            orderService.createOrder(OrderSaveRequest.create("dummy-user" + i, 1000.0 * i, i));
//        }
//    }
//
//    @AfterEach
//    void removeDummy() {
//        jdbcTemplate.update("DELETE FROM orders WHERE buyer LIKE 'dummy-user%'");
//    }
//
//    @Test
//    void getOrderList() {
//        ResponseEntity<OrderPageResponse> response = restTemplate.exchange(getUrl() + "/api/orders", HttpMethod.GET, new HttpEntity<>(header),
//                ParameterizedTypeReference.forType(OrderPageResponse.class));
//
//        OrderPageResponse orderPageResponse = response.getBody();
//
//        assert orderPageResponse != null;
//
//        PageRequest pageRequest = PageRequest.of(0, 20);
//        int orderPageSize = orderPageResponse.getOrders().size();
//
//        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(response.getHeaders().getContentType()).isEqualTo(MediaType.APPLICATION_JSON);
//        assertThat(orderPageSize).isPositive();
//        assertThat(orderPageSize).isEqualTo(orderService.getOrders(pageRequest).getOrders().size());
//        assertThat(orderPageSize).isEqualTo(orderRepository.findAll(pageRequest).getNumberOfElements());
//    }
//
//    @Test
//    void getOrder() {
//        OrderPageResponse orderPageResponse = orderService.getOrders(PageRequest.of(0, 20));
//        Long id = orderPageResponse.getOrders().getFirst().getId();
//
//        ResponseEntity<OrderResponse> response = restTemplate.exchange(getUrl() + "/api/orders/" + id, HttpMethod.GET, new HttpEntity<>(header),
//                ParameterizedTypeReference.forType(OrderResponse.class));
//
//        OrderResponse orderResponse = response.getBody();
//
//        assert orderResponse != null;
//
//        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(response.getHeaders().getContentType()).isEqualTo(MediaType.APPLICATION_JSON);
//        assertThat(orderResponse.getBuyer()).isEqualTo(orderService.getOrderById(id).getBuyer());
//        assertThat(orderResponse.getBuyer()).isEqualTo(orderRepository.findById(id).get().getBuyer());
//    }
//
//    @Test
//    void createOrder() throws Exception {
//        OrderSaveRequest orderSaveRequest = OrderSaveRequest.create("create-test-user", 1000.0, 1);
//
//        ResponseEntity<OrderSaveResponse> response = restTemplate.exchange(getUrl() + "/api/order", HttpMethod.POST,
//                new HttpEntity<>(mapper.writeValueAsString(orderSaveRequest), header), ParameterizedTypeReference.forType(OrderSaveResponse.class));
//
//        OrderSaveResponse orderSaveResponse = response.getBody();
//
//        assert orderSaveResponse != null;
//
//        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
//        assertThat(response.getHeaders().getContentType()).isEqualTo(MediaType.APPLICATION_JSON);
//
//        jdbcTemplate.update("DELETE FROM orders WHERE buyer LIKE 'create-test-user%'");
//    }
//
//    @Test
//    void deleteOrder() throws Exception {
//        OrderPageResponse orderPageResponse = orderService.getOrders(PageRequest.of(0, 20));
//        Long id = orderPageResponse.getOrders().getFirst().getId();
//
//        ResponseEntity<String> response = restTemplate.exchange(getUrl() + "/api/orders/" + id, HttpMethod.DELETE,
//                new HttpEntity<>(header), ParameterizedTypeReference.forType(String.class));
//
//        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(response.getHeaders().getContentType()).isEqualTo(MediaType.APPLICATION_JSON);
//    }
//
//    private String getUrl() {
//        return "http://localhost:" + port;
//    }
}
