package com.join.api.services.product;

import com.join.api.domain.dtos.product.ProductCreateRequestDTO;
import com.join.api.domain.dtos.product.ProductResponseDTO;
import com.join.api.domain.entities.Product;
import com.join.api.domain.repositories.ProductRepository;
import com.join.api.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCreateService implements IProductCreateService {

    @Autowired
    ProductRepository productRepository;

    public ProductResponseDTO execute(ProductCreateRequestDTO productCreateRequestDTO) {

        if (productRepository.existsByName(productCreateRequestDTO.getName())) {
            throw new NotFoundException("Esse nome de produto já foi cadastrado");
        }

        Product newProduct = productCreateRequestDTO.toEntity();

        Product savedProduct = productRepository.save(newProduct);

        return ProductResponseDTO.fromEntity(savedProduct);

    }

}
