package com.api.services.category;

import com.api.domain.dtos.category.CategoryUpdateRequestDTO;

public interface ICategoryUpdateService {

    public void execute(Long categoryId, CategoryUpdateRequestDTO categoryUpdateRequestDTO);
}
