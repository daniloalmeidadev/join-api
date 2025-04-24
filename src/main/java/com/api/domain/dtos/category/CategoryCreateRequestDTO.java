package com.api.domain.dtos.category;

import com.api.domain.entities.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryCreateRequestDTO {

    @NotBlank(message = "O nome não pode ser vazio")
    @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
    private String name;

    @Size(min = 10, max = 200, message = "A descrição deve ter entre 10 e 200 caracteres")
    private String description;

    public Category toEntity() {

        Category category = new Category();

        category.setName(this.name);
        category.setDescription(this.description);

        return category;
    }
}
