package com.api.domain.dtos.product;

import com.api.domain.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductCreateRequestDTO {

    @NotBlank(message = "O nome não pode ser vazio")
    @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
    private String name;

    private BigDecimal price;

    private Integer quantity;

    public Product toEntity() {

        Product product = new Product();

        product.setName(this.name);
        product.setPrice(this.price);
        product.setQuantity(this.quantity);

        return product;
    }
}
