package com.join.api.services.category;

import com.join.api.domain.dtos.category.CategoryResponseDTO;
import com.join.api.domain.entities.Category;
import com.join.api.domain.repositories.CategoryRepository;
import com.join.api.exceptions.NotFoundException;
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
