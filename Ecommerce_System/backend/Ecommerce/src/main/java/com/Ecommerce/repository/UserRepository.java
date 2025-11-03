package com.Ecommerce.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ecommerce.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Optional: find user by email for login
    User findByEmail(String email);
}
