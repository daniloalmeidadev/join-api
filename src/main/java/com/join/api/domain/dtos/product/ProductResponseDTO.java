package com.join.api.domain.dtos.product;

import com.join.api.domain.entities.Product;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class ProductResponseDTO {

    private Long productId;

    private String name;

    private BigDecimal price;

    private Integer quantity;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public static ProductResponseDTO fromEntity(Product product) {

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();

        productResponseDTO.setProductId(product.getProductId());
        productResponseDTO.setName(product.getName());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setQuantity(product.getQuantity());
        productResponseDTO.setCreatedAt(product.getUpdatedAt());
        productResponseDTO.setUpdatedAt(product.getUpdatedAt());

        return productResponseDTO;
    }
}