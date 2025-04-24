package com.api.services.product;

import com.api.domain.dtos.product.ProductResponseDTO;

public interface IProductGetService {

    public ProductResponseDTO execute(Long productId);
}
