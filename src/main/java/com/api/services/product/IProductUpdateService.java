package com.api.services.product;

import com.api.domain.dtos.product.ProductUpdateRequestDTO;

public interface IProductUpdateService {

    public void execute(Long productId, ProductUpdateRequestDTO productUpdateRequestDTO);
}
