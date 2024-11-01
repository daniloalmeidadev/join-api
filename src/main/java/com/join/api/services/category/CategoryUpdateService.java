package com.join.api.services.category;

import com.join.api.domain.dtos.category.CategoryRequestDTO;
import com.join.api.domain.entities.Category;
import com.join.api.domain.repositories.CategoryRepository;
import com.join.api.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryUpdateService implements ICategoryUpdateService {

    @Autowired
    CategoryRepository categoryRepository;

    public void execute(Long categoryId, CategoryRequestDTO categoryRequestDTO) {

        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new NotFoundException("Categoria não encontrada"));

        if (categoryRepository.existsByName(categoryRequestDTO.getName())) {
            throw new NotFoundException("Esse nome de categoria já foi cadastrado");
        }

        category.setName(categoryRequestDTO.getName());
        category.setDescription(categoryRequestDTO.getDescription());

        categoryRepository.save(category);
    }
}
