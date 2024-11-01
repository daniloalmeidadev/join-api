package com.join.api.services.category;

import com.join.api.domain.dtos.category.CategoryRequestDTO;
import com.join.api.domain.dtos.category.CategoryResponseDTO;

public interface ICategoryUpdateService {

    public void execute(Long categoryId, CategoryRequestDTO categoryRequestDTO);
}
