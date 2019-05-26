package com.shoestore.dto.converters;

import com.shoestore.dto.BaseIdDTO;
import com.shoestore.entities.BaseIdEntity;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public interface BaseConverter <D extends BaseIdDTO, E extends BaseIdEntity> {

    default List<D> toDtos(List<E> entities) {
        return entities.stream()
                .filter(Objects::nonNull)
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    D toDto(E entity);

    default List<E> toEntities(List<D> shoeDTOs) {
        return shoeDTOs.stream()
                .filter(Objects::nonNull)
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    E toEntity(D dto);

    E fromId(Long id);
}
