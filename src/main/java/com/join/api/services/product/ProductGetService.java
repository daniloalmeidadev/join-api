package com.join.api.services.product;

import com.join.api.domain.dtos.product.ProductResponseDTO;
import com.join.api.domain.entities.Product;
import com.join.api.domain.repositories.ProductRepository;
import com.join.api.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductGetService implements IProductGetService {

    @Autowired
    ProductRepository productRepository;

    public ProductResponseDTO execute(Long productId) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Produto não encontrado"));

        return ProductResponseDTO.fromEntity(product);
    }
}
