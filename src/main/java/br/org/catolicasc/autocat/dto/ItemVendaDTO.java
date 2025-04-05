package br.org.catolicasc.autocat.dto;

import br.org.catolicasc.autocat.model.ItemVenda;
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
