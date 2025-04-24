package com.api.services.product;

import com.api.domain.dtos.product.ProductCreateRequestDTO;
import com.api.domain.dtos.product.ProductResponseDTO;

public interface IProductCreateService {

    public ProductResponseDTO execute(Long categoryId, ProductCreateRequestDTO productCreateRequestDTO);
}
