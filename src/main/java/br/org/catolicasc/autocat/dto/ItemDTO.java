package br.org.catolicasc.autocat.dto;

import br.org.catolicasc.autocat.model.Produto;
import br.org.catolicasc.autocat.model.Venda;

public record ItemDTO(Long id, Long idProduto, Long idVenda) {
}
