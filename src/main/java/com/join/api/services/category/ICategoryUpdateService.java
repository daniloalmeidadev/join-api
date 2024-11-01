package com.join.api.services.category;

import com.join.api.domain.dtos.category.CategoryRequestDTO;

public interface ICategoryUpdateService {

    public void execute(Long categoryId, CategoryRequestDTO categoryRequestDTO);
}
