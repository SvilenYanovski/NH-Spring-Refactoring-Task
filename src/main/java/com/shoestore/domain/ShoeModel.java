package com.shoestore.domain;

import java.util.List;

public class ShoeModel {
	private long id;
	private String name;
	private String description;
	private List<String> photosUrls;
	
	public ShoeModel(long id, String name, String description, List<String> photosUrls) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.photosUrls = photosUrls;
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public List<String> getPhotosUrls() {
		return photosUrls;
	}
	
}
