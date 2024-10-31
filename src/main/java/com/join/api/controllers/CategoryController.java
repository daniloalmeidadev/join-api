package com.join.api.controllers;

import com.join.api.domain.dtos.category.CategoryRequestDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category/v1")
public class CategoryController {

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryRequestDTO createCategory(@Valid @RequestBody CategoryRequestDTO categoryRequestDTO) {
        return categoryRequestDTO;
    }

}
