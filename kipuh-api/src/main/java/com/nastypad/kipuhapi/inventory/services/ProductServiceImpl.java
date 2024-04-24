package com.nastypad.kipuhapi.inventory.services;

import com.nastypad.kipuhapi.inventory.domain.model.Product;
import com.nastypad.kipuhapi.inventory.domain.repository.ProductRepository;
import com.nastypad.kipuhapi.inventory.domain.service.ProductService;
import com.nastypad.kipuhapi.shared.exception.ResourceNotFoundException;
import com.nastypad.kipuhapi.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {
    private static final String entity = "Product";
    private final ProductRepository productRepository;
    private final Validator validator;

    public ProductServiceImpl(ProductRepository productRepository, Validator validator) {
        this.productRepository = productRepository;
        this.validator = validator;
    }
    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException(entity, productId));
    }

    @Override
    public Product create(Product product) {
        Set<ConstraintViolation<Product>> violations = validator.validate(product);
        if(!violations.isEmpty())
            throw new ResourceValidationException(entity, violations);
        return productRepository.save(product);
    }

    @Override
    public Product update(Product updatedProduct, Long productId) {
        Set<ConstraintViolation<Product>> violations = validator.validate(updatedProduct);
        if(!violations.isEmpty())
            throw new ResourceValidationException(entity, violations);
        if(!productRepository.existsById(productId))
            throw new ResourceValidationException("Product does not exist.");

        Product existingProduct = productRepository.findById(productId).get();
        existingProduct.setName(updatedProduct.getName());
        return productRepository.save(existingProduct);
    }

    @Override
    public ResponseEntity<?> delete(Long productId) {
        return productRepository.findById(productId).map(product -> {
            productRepository.delete(product);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(entity, productId));
    }
}
