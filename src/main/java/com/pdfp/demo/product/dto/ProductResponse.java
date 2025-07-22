package com.pdfp.demo.product.dto;

import java.math.BigDecimal;
import java.time.Instant;

public record ProductResponse(
        Long id,
        String name,
        BigDecimal price,
        Integer stock,
        Instant createdAt,
        Instant updatedAt
) {}