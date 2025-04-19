package br.org.catolicasc.dto;

import br.org.catolicasc.model.SaleItem;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductSaleDTO {

    @NotNull
    private Long productId;


    public ProductSaleDTO() {
    }

    public ProductSaleDTO(SaleItem saleItem) {
        this.productId = saleItem.getProduct().getId();
    }
}
