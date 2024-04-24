package com.nastypad.kipuhapi.inventory.domain.service;

import com.nastypad.kipuhapi.inventory.domain.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    Product getById(Long id);
    Product create(Product newProduct);
    Product update(Product updatedProduct, Long id);
    ResponseEntity<?> delete(Long id);
}
