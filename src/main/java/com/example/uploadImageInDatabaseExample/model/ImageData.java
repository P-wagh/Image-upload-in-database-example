package com.example.uploadImageInDatabaseExample.model;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class ImageData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private byte[] imageData;
	
	public ImageData() {
		super();
	}

	public ImageData(Long id, String title, String description, byte[] imageData) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.imageData = imageData;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	@Override
	public String toString() {
		return "ImageData [id=" + id + ", title=" + title + ", description=" + description + ", imageData="
				+ Arrays.toString(imageData) + "]";
	}
	
	
	
}
