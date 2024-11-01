package com.join.api.services.product;

import com.join.api.domain.dtos.product.ProductUpdateRequestDTO;

public interface IProductUpdateService {

    public void execute(Long productId, ProductUpdateRequestDTO productUpdateRequestDTO);
}
