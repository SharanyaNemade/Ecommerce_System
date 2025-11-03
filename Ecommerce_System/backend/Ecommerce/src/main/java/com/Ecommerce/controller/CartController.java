package com.Ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Ecommerce.model.Cart;
import com.Ecommerce.model.User;
import com.Ecommerce.service.CartService;
import com.Ecommerce.service.UserService;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    // Add item to cart
    @PostMapping("/add")
    public Cart addToCart(@RequestBody Cart cart) {
        return cartService.addToCart(cart);
    }

    // Get all cart items for a user
    @GetMapping("/user/{userId}")
    public List<Cart> getCartItems(@PathVariable Long userId) {
        User user = userService.getUserById(userId).orElse(null);
        return cartService.getCartItemsByUser(user);
    }

    // Remove a cart item by cartId
    @DeleteMapping("/remove/{cartId}")
    public void removeFromCart(@PathVariable Long cartId) {
        cartService.removeFromCart(cartId);
    }

    // Clear all cart items for a user
    @DeleteMapping("/clear/{userId}")
    public void clearCart(@PathVariable Long userId) {
        User user = userService.getUserById(userId).orElse(null);
        cartService.clearCart(user);
    }
}
