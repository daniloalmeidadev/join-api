package com.api.controllers;

import com.api.domain.dtos.product.ProductCreateRequestDTO;
import com.api.domain.dtos.product.ProductResponseDTO;
import com.api.domain.dtos.product.ProductUpdateRequestDTO;
import com.api.services.product.IProductCreateService;
import com.api.services.product.IProductDeleteService;
import com.api.services.product.IProductGetService;
import com.api.services.product.IProductUpdateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/")
public class ProductController {

    @Autowired
    private IProductCreateService productCreateService;

    @Autowired
    private IProductGetService productGetService;

    @Autowired
    private IProductUpdateService productUpdateService;

    @Autowired
    private IProductDeleteService productDeleteService;

    @PostMapping("/categories/{categoryId}/products")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponseDTO createProduct(
            @PathVariable Long categoryId,
            @Valid @RequestBody ProductCreateRequestDTO productCreateRequestDTO) {

        return productCreateService.execute(categoryId, productCreateRequestDTO);
    }

    @GetMapping("/products/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponseDTO consultProduct(@PathVariable Long productId) {

        return productGetService.execute(productId);
    }

    @PutMapping("/products/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProduct(
            @PathVariable Long productId,
            @Valid @RequestBody ProductUpdateRequestDTO productUpdateRequestDTO) {

        productUpdateService.execute(productId, productUpdateRequestDTO);
    }

    @DeleteMapping("/products/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long productId) {

        productDeleteService.execute(productId);
    }
}
