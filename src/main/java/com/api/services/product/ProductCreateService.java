package com.api.services.product;

import com.api.domain.dtos.product.ProductCreateRequestDTO;
import com.api.domain.dtos.product.ProductResponseDTO;
import com.api.domain.entities.Category;
import com.api.domain.entities.Product;
import com.api.domain.repositories.CategoryRepository;
import com.api.domain.repositories.ProductRepository;
import com.api.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCreateService implements IProductCreateService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public ProductResponseDTO execute(Long categoryId, ProductCreateRequestDTO productCreateRequestDTO) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NotFoundException("Categoria não encontrada"));

        if (productRepository.existsByName(productCreateRequestDTO.getName())) {
            throw new NotFoundException("Esse nome de produto já foi cadastrado");
        }

        Product newProduct = productCreateRequestDTO.toEntity();
        newProduct.setCategory(category);

        Product savedProduct = productRepository.save(newProduct);

        return ProductResponseDTO.fromEntity(savedProduct);

    }

}
