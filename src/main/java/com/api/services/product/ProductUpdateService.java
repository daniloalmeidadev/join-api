package com.api.services.product;

import com.api.domain.dtos.product.ProductUpdateRequestDTO;
import com.api.domain.entities.Product;
import com.api.domain.repositories.ProductRepository;
import com.api.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductUpdateService implements IProductUpdateService {

    @Autowired
    ProductRepository productRepository;

    public void execute(Long productId, ProductUpdateRequestDTO productUpdateRequestDTO) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Produto não encontrado"));

        if (productUpdateRequestDTO.getName() != null) {
            if (productRepository.existsByName(productUpdateRequestDTO.getName())) {
                throw new NotFoundException("Esse nome de produto já foi cadastrado");
            }
            product.setName(productUpdateRequestDTO.getName());
        }
        if (productUpdateRequestDTO.getPrice() != null) {
            product.setPrice(productUpdateRequestDTO.getPrice());
        }
        if (productUpdateRequestDTO.getQuantity() != null) {
            product.setQuantity(productUpdateRequestDTO.getQuantity());
        }

        productRepository.save(product);
    }
}
