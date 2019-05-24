package com.shoestore.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class SizeAvailability {

    @EmbeddedId
    private SizeAvailabilityKey id;

    @ManyToOne
    @MapsId("shoe_id")
    @JoinColumn(name = "shoe_id")
    private Shoe shoe;

    @ManyToOne
    @MapsId("size_id")
    @JoinColumn(name = "size_id")
    private Size size;

    @Column(name = "availability")
    private int availability = 0;

    public SizeAvailability() {}
}
