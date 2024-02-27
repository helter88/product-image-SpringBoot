package com.example.photoform.products.controller;

import com.example.photoform.products.model.Product;
import com.example.photoform.products.model.dto.ProductDto;
import com.example.photoform.products.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ObjectMapper objectMapper;

    @PostMapping
    public ResponseEntity<?> addProduct(
            @RequestParam("productData") String productData,
            @RequestParam(value = "images", required = false) List<MultipartFile> images) {

        // Deserializacja JSON do obiektu ProductDTO
        try {
            ProductDto productDTO = objectMapper.readValue(productData, ProductDto.class);
            productService.saveProduct(productDTO, images);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid product data");
        }

        // Przetwarzanie i zapis obrazów oraz danych produktu
        // ...

        return ResponseEntity.ok("Product added successfully");
    }
}
