package com.caiodev.dsecommerce.repositories;

import com.caiodev.dsecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
