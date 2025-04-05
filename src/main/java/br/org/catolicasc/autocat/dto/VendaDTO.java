package br.org.catolicasc.autocat.dto;

import br.org.catolicasc.autocat.model.Venda;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
public class VendaDTO {
    private Long id;
    private LocalDateTime dateTime;
    private List<ItemVendaDTO> itensVenda;

    public VendaDTO(Venda venda) {
        this.id = venda.getId();
        this.dateTime = venda.getDateTime();
        this.itensVenda = venda.getVendaList().stream()
                .map(ItemVendaDTO::new)
                .collect(Collectors.toList());
    }
}

