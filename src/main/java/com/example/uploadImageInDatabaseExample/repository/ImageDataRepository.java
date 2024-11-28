package com.example.uploadImageInDatabaseExample.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.uploadImageInDatabaseExample.model.ImageData;

public interface ImageDataRepository extends JpaRepository<ImageData, Long> {

	Optional<ImageData> findByTitle(String title);
}
