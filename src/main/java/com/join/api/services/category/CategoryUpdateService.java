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

        Category generator = categoryRepository.findById(categoryId).orElseThrow(() -> new NotFoundException("Categoria não encontrada"));

        Optional<Category> existingCategory = categoryRepository.findByName(categoryRequestDTO.getName());
        if (existingCategory.isPresent()) {
            throw new NotFoundException("Esse nome de categoria já foi cadastrado");
        }

        Category newCategory = categoryRequestDTO.toEntity();

        newCategory.setCategoryId(categoryId);
        newCategory.setCreatedAt(generator.getCreatedAt());

        categoryRepository.save(newCategory);
    }
}
