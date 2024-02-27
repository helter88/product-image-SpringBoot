package com.example.photoform.products.service;

import com.example.photoform.products.model.Image;
import com.example.photoform.products.model.Product;
import com.example.photoform.products.model.ProductImage;
import com.example.photoform.products.model.dto.ProductDto;
import com.example.photoform.products.repository.ImageRepository;
import com.example.photoform.products.repository.ProductImageRepository;
import com.example.photoform.products.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ImageRepository imageRepository;
    private final ProductImageRepository productImageRepository;

    public void saveProduct(ProductDto productDTO, List<MultipartFile> images) throws IOException {
        // Tworzenie i zapis produktu
        Product product = Product.builder()
                .name(productDTO.name())
                .description(productDTO.description())
                .price(productDTO.price())
                .build();

        product = productRepository.save(product);

        // Przetwarzanie i zapis obrazów
        for (MultipartFile file : images) {
            Image image = Image.builder()
                    .filename(file.getOriginalFilename())
                    .filetype(file.getContentType())
                    .image(file.getBytes())
                    .build();

            image = imageRepository.save(image);

            ProductImage productImage = ProductImage.builder()
                    .product(product)
                    .image(image)
                    .build();

            productImageRepository.save(productImage);
        }
    }
}
