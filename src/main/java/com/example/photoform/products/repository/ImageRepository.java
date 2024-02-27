package com.example.photoform.products.repository;

import com.example.photoform.products.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
