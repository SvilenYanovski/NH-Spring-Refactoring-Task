package com.shoestore.entities.shoe;

import com.shoestore.entities.BaseIdEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Shoe  extends BaseIdEntity {

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
