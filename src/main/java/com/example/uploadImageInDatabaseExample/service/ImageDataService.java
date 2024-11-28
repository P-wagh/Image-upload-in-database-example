package com.example.uploadImageInDatabaseExample.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.uploadImageInDatabaseExample.model.ImageData;
import com.example.uploadImageInDatabaseExample.repository.ImageDataRepository;
import com.example.uploadImageInDatabaseExample.utils.ImageUtils;

@Service
public class ImageDataService {

	@Autowired
	private ImageDataRepository imageDataRepository;

	public String uploadImage(MultipartFile file,String title, String description) throws IOException {
		ImageData imageData = new ImageData();
		imageData.setDescription(description);
		imageData.setTitle(title);
		imageData.setImageData(ImageUtils.compressImage(file.getBytes()));
		this.imageDataRepository.save(imageData);
		return "File uploaded successfully: " + file.getOriginalFilename();
	}
	
	public byte[] downloadImage(String fileName){
        Optional<ImageData> dbImageData = imageDataRepository.findByTitle(fileName);
        byte[] images=ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }
}
