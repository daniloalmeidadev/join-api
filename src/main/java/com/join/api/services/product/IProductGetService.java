package com.join.api.services.product;

import com.join.api.domain.dtos.product.ProductResponseDTO;

public interface IProductGetService {

    public ProductResponseDTO execute(Long productId);
}
