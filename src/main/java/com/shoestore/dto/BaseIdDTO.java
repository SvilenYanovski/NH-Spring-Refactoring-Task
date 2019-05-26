package com.shoestore.dto;

import com.shoestore.entities.BaseIdEntity;
import lombok.Data;

@Data
public abstract class BaseIdDTO implements BaseDTO{
    private Long id;

    public BaseIdDTO(BaseIdEntity entity){
        this.id = entity.getId();
    }
}
