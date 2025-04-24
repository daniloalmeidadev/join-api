package com.api.services.product;

import com.api.domain.dtos.product.ProductResponseDTO;
import com.api.domain.entities.Product;
import com.api.domain.repositories.ProductRepository;
import com.api.exceptions.NotFoundException;
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
