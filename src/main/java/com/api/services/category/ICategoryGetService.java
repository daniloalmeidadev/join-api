package com.api.services.category;

import com.api.domain.dtos.category.CategoryResponseDTO;

public interface ICategoryGetService {

    public CategoryResponseDTO execute(Long categoryId);
}
