package hsh.demo.restdocs.order.repository;

import hsh.demo.restdocs.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
