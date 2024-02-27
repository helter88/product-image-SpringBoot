package com.example.photoform.products.model.dto;

import java.math.BigDecimal;
import java.util.List;

public record ProductDto(
        String name,
        String description,
        BigDecimal price
) {
}
