package com.join.api.controllers;

import com.join.api.domain.dtos.category.CategoryRequestDTO;
import com.join.api.domain.dtos.category.CategoryResponseDTO;
import com.join.api.services.category.ICategoryCreateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category/v1")
public class CategoryController {

    @Autowired
    private ICategoryCreateService categoryCreateService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponseDTO createCategory(@Valid @RequestBody CategoryRequestDTO categoryRequestDTO) {

        return categoryCreateService.execute(categoryRequestDTO);
    }

}
