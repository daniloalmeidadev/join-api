package com.join.api.controllers;

import com.join.api.domain.dtos.product.ProductCreateRequestDTO;
import com.join.api.domain.dtos.product.ProductResponseDTO;
import com.join.api.domain.dtos.product.ProductUpdateRequestDTO;
import com.join.api.services.product.IProductCreateService;
import com.join.api.services.product.IProductGetService;
import com.join.api.services.product.IProductUpdateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @Autowired
    private IProductCreateService productCreateService;

    @Autowired
    private IProductGetService productGetService;

    @Autowired
    private IProductUpdateService productUpdateService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponseDTO createProduct(@Valid @RequestBody ProductCreateRequestDTO productCreateRequestDTO) {

        return productCreateService.execute(productCreateRequestDTO);
    }

    @GetMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponseDTO consultProduct(@PathVariable Long productId) {

        return productGetService.execute(productId);
    }

    @PutMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProduct(
            @PathVariable Long productId,
            @Valid @RequestBody ProductUpdateRequestDTO productUpdateRequestDTO) {

        productUpdateService.execute(productId, productUpdateRequestDTO);
    }

    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct() {

    }
}
