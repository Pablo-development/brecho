package br.org.catolicasc.dto;

import br.org.catolicasc.model.ItemVenda;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProdutoVendaDTO {

    @NotNull
    private Long idProduto;


    public ProdutoVendaDTO() {
    }

    public ProdutoVendaDTO(ItemVenda itemVenda) {
        this.idProduto = itemVenda.getProduto().getId();
    }
}
