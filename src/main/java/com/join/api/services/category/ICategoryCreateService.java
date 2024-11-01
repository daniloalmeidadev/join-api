package com.join.api.services.category;

import com.join.api.domain.dtos.category.CategoryCreateRequestDTO;
import com.join.api.domain.dtos.category.CategoryResponseDTO;

public interface ICategoryCreateService {

    public CategoryResponseDTO execute(CategoryCreateRequestDTO categoryCreateRequestDTO);
}
