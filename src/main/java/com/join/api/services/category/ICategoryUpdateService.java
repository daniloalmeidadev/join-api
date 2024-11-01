package com.join.api.services.category;

import com.join.api.domain.dtos.category.CategoryUpdateRequestDTO;

public interface ICategoryUpdateService {

    public void execute(Long categoryId, CategoryUpdateRequestDTO categoryUpdateRequestDTO);
}
