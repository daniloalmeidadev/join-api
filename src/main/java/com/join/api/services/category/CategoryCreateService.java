package com.join.api.services.category;

import com.join.api.domain.dtos.category.CategoryRequestDTO;
import com.join.api.domain.dtos.category.CategoryResponseDTO;
import com.join.api.domain.entities.Category;
import com.join.api.domain.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryCreateService implements ICategoryCreateService {

    @Autowired
    CategoryRepository categoryRepository;

    public CategoryResponseDTO execute(CategoryRequestDTO categoryRequestDTO) {

        Category categoryToSave = categoryRequestDTO.toEntity();

        Category categorySaved = categoryRepository.save(categoryToSave);

        return CategoryResponseDTO.fromEntity(categorySaved);
    }

}
