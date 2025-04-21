package br.org.catolicasc.dto;

import br.org.catolicasc.model.SaleItem;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
public class SaleItemDTO extends ProductItemSaleDTO {

    @NotNull
    private Long saleItemId;

    public SaleItemDTO(SaleItem saleItem) {
        super(saleItem);
        this.saleItemId = saleItem.getIdItem();
    }
}
