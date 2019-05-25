package com.shoestore.entities.inventory;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class SizeAvailabilityKey  implements Serializable {
    @Column(name = "shoe_id")
    private Long shoeId;
    @Column(name = "size_id")
    private Long sizeId;

    public SizeAvailabilityKey() {}
}
