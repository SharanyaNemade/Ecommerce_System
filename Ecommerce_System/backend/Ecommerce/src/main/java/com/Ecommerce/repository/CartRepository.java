package com.Ecommerce.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ecommerce.model.Cart;
import com.Ecommerce.model.User;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    
    // Find all cart items for a specific user
    List<Cart> findByUser(User user);
}

