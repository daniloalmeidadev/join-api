package com.join.api.services.product;

import com.join.api.domain.dtos.product.ProductCreateRequestDTO;
import com.join.api.domain.dtos.product.ProductResponseDTO;

public interface IProductCreateService {

    public ProductResponseDTO execute(ProductCreateRequestDTO productCreateRequestDTO);
}
