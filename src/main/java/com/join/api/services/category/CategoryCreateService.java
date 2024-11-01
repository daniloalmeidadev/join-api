package com.join.api.services.category;

import com.join.api.domain.dtos.category.CategoryCreateRequestDTO;
import com.join.api.domain.dtos.category.CategoryResponseDTO;
import com.join.api.domain.entities.Category;
import com.join.api.domain.repositories.CategoryRepository;
import com.join.api.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryCreateService implements ICategoryCreateService {

    @Autowired
    CategoryRepository categoryRepository;

    public CategoryResponseDTO execute(CategoryCreateRequestDTO categoryCreateRequestDTO) {

        if (categoryRepository.existsByName(categoryCreateRequestDTO.getName())) {
            throw new NotFoundException("Esse nome de categoria já foi cadastrado");
        }

        Category newCategory = categoryCreateRequestDTO.toEntity();

        Category savedCategory = categoryRepository.save(newCategory);

        return CategoryResponseDTO.fromEntity(savedCategory);
    }
}
