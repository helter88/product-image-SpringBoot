package com.example.photoform.products.model.dto;

import com.example.photoform.products.model.Image;

import java.math.BigDecimal;
import java.util.List;

public record ProductDto(
        String name,
        String description,
        BigDecimal price
) {
}
