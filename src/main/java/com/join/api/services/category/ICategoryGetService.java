package com.join.api.services.category;

import com.join.api.domain.dtos.category.CategoryResponseDTO;

import java.util.List;

public interface ICategoryGetService {

    public CategoryResponseDTO execute(Long categoryId);
}
