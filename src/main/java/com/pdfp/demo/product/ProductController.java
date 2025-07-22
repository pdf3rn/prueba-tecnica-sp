package com.pdfp.demo.product;

import com.pdfp.demo.product.dto.ProductRequest;
import com.pdfp.demo.product.dto.ProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Productos", description = "CRUD de productos")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @Operation(summary = "Obtener todos los productos")
    @GetMapping
    public List<ProductResponse> getAll() {
        return service.findAll();
    }

    @Operation(summary = "Obtener un producto por id", parameters = {
            @Parameter(name = "id", description = "ID del producto", example = "1")
    })
    @GetMapping("/{id}")
    public ProductResponse getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @Operation(summary = "Crear un producto")
    @PostMapping
    public ResponseEntity<ProductResponse> create(@Valid @RequestBody ProductRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @Operation(summary = "Actualizar un producto", parameters = {
            @Parameter(name = "id", description = "ID del producto", example = "1")
    })
    @PutMapping("/{id}")
    public ProductResponse update(@PathVariable Long id, @Valid @RequestBody ProductRequest request) {
        return service.update(id, request);
    }

    @Operation(summary = "Eliminar un producto", parameters = {
            @Parameter(name = "id", description = "ID del producto", example = "2")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<ProductResponse> delete(@PathVariable Long id) {
        ProductResponse record = service.findById(id);
        service.delete(id);
        return ResponseEntity.ok(record);
    }

}