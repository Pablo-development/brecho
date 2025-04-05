package br.org.catolicasc.autocat.dto;

import br.org.catolicasc.autocat.model.ItemVenda;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProdutoVendaDTO {

    @NotNull
    private Long idProduto;

    @NotNull
    private Long idVenda;

    public ProdutoVendaDTO() {
    }

    public ProdutoVendaDTO(ItemVenda itemVenda) {
        this.idProduto = itemVenda.getProduto().getId();
        this.idVenda = itemVenda.getVenda().getId();
    }
}
