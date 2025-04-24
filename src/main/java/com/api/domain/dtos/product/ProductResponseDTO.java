package com.api.domain.dtos.product;

import com.api.domain.entities.Category;
import com.api.domain.entities.Product;
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

    private Category category;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public static ProductResponseDTO fromEntity(Product product) {

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();

        productResponseDTO.setProductId(product.getProductId());
        productResponseDTO.setName(product.getName());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setQuantity(product.getQuantity());
        productResponseDTO.setCategory(product.getCategory());
        productResponseDTO.setCreatedAt(product.getUpdatedAt());
        productResponseDTO.setUpdatedAt(product.getUpdatedAt());

        return productResponseDTO;
    }
}
