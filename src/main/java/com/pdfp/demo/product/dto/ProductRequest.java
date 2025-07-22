package com.pdfp.demo.product.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record ProductRequest(
        @NotBlank @Column(unique = true) String name,
        @DecimalMin("1.00") BigDecimal price,
        @Min(0) Integer stock
) {}