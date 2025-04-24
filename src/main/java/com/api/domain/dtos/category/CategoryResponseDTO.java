package com.api.domain.dtos.category;

import com.api.domain.entities.Category;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CategoryResponseDTO {

    private Long categoryId;

    private String name;

    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public static CategoryResponseDTO fromEntity(Category category) {

        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();

        categoryResponseDTO.setCategoryId(category.getCategoryId());
        categoryResponseDTO.setName(category.getName());
        categoryResponseDTO.setDescription(category.getDescription());
        categoryResponseDTO.setCreatedAt(category.getUpdatedAt());
        categoryResponseDTO.setUpdatedAt(category.getUpdatedAt());

        return categoryResponseDTO;
    }
}
