package com.join.api.controllers;

import com.join.api.domain.dtos.category.CategoryRequestDTO;
import com.join.api.domain.dtos.category.CategoryResponseDTO;
import com.join.api.services.category.ICategoryCreateService;
import com.join.api.services.category.ICategoryDeleteService;
import com.join.api.services.category.ICategoryGetService;
import com.join.api.services.category.ICategoryUpdateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/category")
public class CategoryController {

    @Autowired
    private ICategoryCreateService categoryCreateService;

    @Autowired
    private ICategoryGetService categoryGetService;

    @Autowired
    private ICategoryUpdateService categoryUpdateService;

    @Autowired
    private ICategoryDeleteService categoryDeleteService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponseDTO createCategory(@Valid @RequestBody CategoryRequestDTO categoryRequestDTO) {

        return categoryCreateService.execute(categoryRequestDTO);
    }

    @GetMapping("/{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryResponseDTO listCategory(@PathVariable Long categoryId) {

        return categoryGetService.execute(categoryId);
    }

    @PutMapping("/{categoryId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCategory(
            @PathVariable Long categoryId,
            @Valid @RequestBody CategoryRequestDTO categoryRequestDTO) {

        categoryUpdateService.execute(categoryId, categoryRequestDTO);
    }

    @DeleteMapping("/{categoryId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable Long categoryId) {

        categoryDeleteService.execute(categoryId);
    }
}
