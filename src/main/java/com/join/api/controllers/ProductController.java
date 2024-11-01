package com.join.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct() {

    }

    @GetMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public void consultProduct() {

    }

    @PutMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProduct() {

    }

    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct() {

    }
}
