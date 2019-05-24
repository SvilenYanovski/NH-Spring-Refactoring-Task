package com.shoestore.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Shoe {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String description;
	@OneToMany
	private List<Photo> photos;

	public Shoe() {}
	public Shoe(String name, String description, List<Photo> photosUrls) {
		this.name = name;
		this.description = description;
		this.photos = photosUrls;
	}
}
