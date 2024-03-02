package com.example.photoform.products.model.dto;

public record ImageDto(
        Long id,
        String filename,
        String filetype,
        String base64
) {
}
