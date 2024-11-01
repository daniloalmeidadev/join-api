package com.join.api.services.category;

import com.join.api.domain.dtos.category.CategoryUpdateRequestDTO;
import com.join.api.domain.entities.Category;
import com.join.api.domain.repositories.CategoryRepository;
import com.join.api.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryUpdateService implements ICategoryUpdateService {

    @Autowired
    CategoryRepository categoryRepository;

    public void execute(Long categoryId, CategoryUpdateRequestDTO categoryUpdateRequestDTO) {

        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new NotFoundException("Categoria não encontrada"));

        if (categoryUpdateRequestDTO.getName() != null) {
            if (categoryRepository.existsByName(categoryUpdateRequestDTO.getName())) {
                throw new NotFoundException("Esse nome de categoria já foi cadastrado");
            }
            category.setName(categoryUpdateRequestDTO.getName());
        }
        if (categoryUpdateRequestDTO.getDescription() != null) {
            category.setDescription(categoryUpdateRequestDTO.getDescription());
        }

        categoryRepository.save(category);
    }
}
