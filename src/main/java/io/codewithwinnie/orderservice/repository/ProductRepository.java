package io.codewithwinnie.orderservice.repository;

import io.codewithwinnie.orderservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
