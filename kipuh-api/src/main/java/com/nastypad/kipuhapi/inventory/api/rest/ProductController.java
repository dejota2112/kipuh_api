package com.nastypad.kipuhapi.inventory.api.rest;

import com.nastypad.kipuhapi.inventory.domain.service.ProductService;
import com.nastypad.kipuhapi.inventory.mapping.mappers.ProductMapper;
import com.nastypad.kipuhapi.inventory.resources.create.CreateProductResource;
import com.nastypad.kipuhapi.inventory.resources.show.ProductResource;
import com.nastypad.kipuhapi.inventory.resources.update.UpdateProductResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/products", produces = "application/json")
@Tag(name = "Product", description = "CRUD for products")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping("all")
    public List<ProductResource> getAllSkills() {
        return productMapper.toListResource(productService.getProducts());
    }

    @GetMapping("{id}")
    public ProductResource getById(@PathVariable Long id) {
        return productMapper.toResource(productService.getById(id));
    }

    @PostMapping
    public ProductResource createProduct(@RequestBody CreateProductResource productResource) {
        return productMapper.toResource(productService.create(productMapper.createResourceToModel(productResource)));
    }

    @PutMapping("{id}")
    public ProductResource updateProduct(@PathVariable Long id, @RequestBody UpdateProductResource productResource) {
        return productMapper.toResource(productService.update(productMapper.updateResourceToModel(productResource), id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        return productService.delete(id);
    }
}