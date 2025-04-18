package br.org.catolicasc.dto;

import br.org.catolicasc.model.ItemVenda;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
public class ItemVendaDTO extends ProdutoVendaDTO {

    @NotNull
    private Long idItemVenda;

    public ItemVendaDTO(ItemVenda itemVenda) {
        super(itemVenda);
        this.idItemVenda = itemVenda.getIdItem();
    }
}
