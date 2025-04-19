package br.org.catolicasc.dto;

import br.org.catolicasc.model.SaleItem;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductItemSaleDTO {

    @NotNull
    private Long productId;


    public ProductItemSaleDTO() {
    }

    public ProductItemSaleDTO(SaleItem saleItem) {
        this.productId = saleItem.getProduct().getId();
    }
}
