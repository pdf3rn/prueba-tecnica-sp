package com.pdfp.demo.product;

import com.pdfp.demo.product.dto.ProductRequest;
import com.pdfp.demo.product.dto.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<ProductResponse> findAll() {
        return repository.findAll().stream()
                .map(ProductMapper::toResponse)
                .toList();
    }

    public ProductResponse findById(Long id) {
        return repository.findById(id)
                .map(ProductMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    public ProductResponse create(ProductRequest request) {
        Product saved = repository.save(ProductMapper.toEntity(request));
        return ProductMapper.toResponse(saved);
    }

    public ProductResponse update(Long id, ProductRequest request) {
        Product existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        ProductMapper.update(existing, request);
        return ProductMapper.toResponse(repository.save(existing));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}