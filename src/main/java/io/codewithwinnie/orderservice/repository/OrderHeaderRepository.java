package io.codewithwinnie.orderservice.repository;

import io.codewithwinnie.orderservice.entity.OrderHeader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderHeaderRepository extends JpaRepository<OrderHeader, Long> {
}
