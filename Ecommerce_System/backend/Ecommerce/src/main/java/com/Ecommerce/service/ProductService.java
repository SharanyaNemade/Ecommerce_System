package com.Ecommerce.service;

import com.Ecommerce.model.Product;
import com.Ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Create a new product
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get product by ID
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Get products by category
    public List<Product> getProductsByCategoryId(Integer categoryId) {
        return productRepository.findByCategoryCategoryId(categoryId.longValue());
    }

    // Update product
    public Product updateProduct(Long id, Product updatedProduct) {
        return productRepository.findById(id).map(product -> {
            product.setName(updatedProduct.getName());
            product.setDescription(updatedProduct.getDescription());
            product.setPrice(updatedProduct.getPrice());
            product.setStock(updatedProduct.getStock());
            product.setStatus(updatedProduct.getStatus());
            product.setCategory(updatedProduct.getCategory());
            product.setImageUrl(updatedProduct.getImageUrl());
            return productRepository.save(product);
        }).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // Soft delete product
    public void deleteProduct(Long id) {
        productRepository.findById(id).ifPresent(product -> {
            product.setStatus(Product.Status.INACTIVE);
            productRepository.save(product);
        });
    }
}
