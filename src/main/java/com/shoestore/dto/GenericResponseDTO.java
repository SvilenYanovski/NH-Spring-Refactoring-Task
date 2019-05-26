package com.shoestore.dto;

import lombok.Data;

import java.util.List;

@Data
public class GenericResponseDTO {
    private String value;

    private List<String> errors;
}
