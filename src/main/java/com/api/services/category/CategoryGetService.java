package com.api.services.category;

import com.api.domain.dtos.category.CategoryResponseDTO;
import com.api.domain.entities.Category;
import com.api.domain.repositories.CategoryRepository;
import com.api.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryGetService implements ICategoryGetService {

    @Autowired
    CategoryRepository categoryRepository;

    public CategoryResponseDTO execute(Long categoryId) {

        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new NotFoundException("Categoria não encontrada"));

        return CategoryResponseDTO.fromEntity(category);
    }
}
