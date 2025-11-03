package com.Ecommerce.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ecommerce.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Find products by category
    List<Product> findByCategoryCategoryId(Long categoryId);

    // Find active products
    List<Product> findByStatus(Product.Status status);
}
