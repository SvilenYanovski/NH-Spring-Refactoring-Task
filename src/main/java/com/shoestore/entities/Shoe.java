package com.shoestore.entities;

import lombok.Data;

import javax.persistence.*;
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
	@ManyToMany
	@JoinTable(
			name = "shoe_size",
			joinColumns = @JoinColumn(name = "shoe_id"),
			inverseJoinColumns = @JoinColumn(name = "size_id"))
	private List<Size> sizes;
	@OneToMany
	private List<SizeAvailability> availabilities;

	public Shoe() {}
	public Shoe(String name, String description, List<Photo> photosUrls, List<Size> sizes) {
		this.name = name;
		this.description = description;
		this.photos = photosUrls;
		this.sizes = sizes;
	}
}
