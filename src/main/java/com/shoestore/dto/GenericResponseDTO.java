package com.shoestore.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Generic DTO object for passing simple value like total price or number of items in shopping cart.
 *
 */
@Data
public class GenericResponseDTO {
    private String value;

    private List<String> errors = new ArrayList<>(0);
}
