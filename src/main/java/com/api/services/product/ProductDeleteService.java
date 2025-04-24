package com.api.services.product;

import com.api.domain.repositories.ProductRepository;
import com.api.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDeleteService implements IProductDeleteService {

    @Autowired
    ProductRepository productRepository;

    public void execute(Long productId) {

        productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Produto não encontrado"));

        productRepository.deleteById(productId);
    }
}
