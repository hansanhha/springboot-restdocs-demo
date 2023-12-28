package hansanhha.spring.restdocs.order.repository;

import hansanhha.spring.restdocs.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
