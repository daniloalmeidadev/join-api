package com.join.api.services.category;

import com.join.api.domain.dtos.category.CategoryRequestDTO;
import com.join.api.domain.dtos.category.CategoryResponseDTO;

public interface ICategoryCreateService {

    public CategoryResponseDTO execute(CategoryRequestDTO categoryRequestDTO);
}
