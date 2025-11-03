package com.Ecommerce.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.model.Cart;
import com.Ecommerce.model.User;
import com.Ecommerce.repository.CartRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    // Add a new item to cart
    public Cart addToCart(Cart cart) {
        return cartRepository.save(cart);
    }

    // Get all cart items for a specific user
    public List<Cart> getCartItemsByUser(User user) {
        return cartRepository.findByUser(user);
    }

    // Remove a cart item by cartId
    public void removeFromCart(Long cartId) {
        cartRepository.deleteById(cartId);
    }

    // Clear all cart items for a user
    public void clearCart(User user) {
        List<Cart> items = cartRepository.findByUser(user);
        cartRepository.deleteAll(items);
    }
}
