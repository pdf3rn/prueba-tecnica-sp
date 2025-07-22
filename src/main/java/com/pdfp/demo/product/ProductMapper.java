package com.pdfp.demo.product;

import com.pdfp.demo.product.dto.ProductRequest;
import com.pdfp.demo.product.dto.ProductResponse;

public class ProductMapper {

    public static ProductResponse toResponse(Product p) {
        return new ProductResponse(
                p.getId(),
                p.getName(),
                p.getPrice(),
                p.getStock(),
                p.getCreatedAt(),
                p.getUpdatedAt()
        );
    }

    public static Product toEntity(ProductRequest req) {
        Product p = new Product();
        update(p, req);
        return p;
    }

    public static void update(Product product, ProductRequest req) {
        product.setName(req.name());
        product.setPrice(req.price());
        product.setStock(req.stock());
    }
}