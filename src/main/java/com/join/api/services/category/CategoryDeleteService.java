package com.join.api.services.category;

import com.join.api.domain.repositories.CategoryRepository;
import com.join.api.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryDeleteService implements ICategoryDeleteService{

    @Autowired
    CategoryRepository categoryRepository;

    public void execute(Long categoryId) {

        categoryRepository.findById(categoryId).orElseThrow(() -> new NotFoundException("Categoria não encontrada"));

        categoryRepository.deleteById(categoryId);
    }
}
