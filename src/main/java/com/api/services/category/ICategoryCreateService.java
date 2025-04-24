package com.api.services.category;

import com.api.domain.dtos.category.CategoryCreateRequestDTO;
import com.api.domain.dtos.category.CategoryResponseDTO;

public interface ICategoryCreateService {

    public CategoryResponseDTO execute(CategoryCreateRequestDTO categoryCreateRequestDTO);
}
