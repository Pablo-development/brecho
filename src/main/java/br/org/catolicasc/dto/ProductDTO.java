package br.org.catolicasc.dto;

import br.org.catolicasc.model.Category;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductDTO {

    @NotNull
    @Min(value = 0)
    private Double price;

    @NotNull
    @Min(value = 0)
    private int quantity;

    @NotNull
    private Category category;
}
