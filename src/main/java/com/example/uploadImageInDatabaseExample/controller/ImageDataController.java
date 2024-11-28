package com.example.uploadImageInDatabaseExample.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.uploadImageInDatabaseExample.service.ImageDataService;

@RestController
@RequestMapping("/image")
public class ImageDataController {

	@Autowired
	private ImageDataService imageDataService;
	
	@PostMapping
	public ResponseEntity<?> uploadImage(
			@RequestParam("image") MultipartFile file,
			@RequestParam("title") String title, 
			@RequestParam("description") String description) throws IOException{
		
		String uploadImage = imageDataService.uploadImage(file, title, description);
		return ResponseEntity.status(HttpStatus.OK)
				.body(uploadImage);
	}
	
	@GetMapping("/{fileName}")
	public ResponseEntity<?> downloadImage(@PathVariable String fileName){
		byte[] imageData=imageDataService.downloadImage(fileName);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(imageData);

	}
	
}
