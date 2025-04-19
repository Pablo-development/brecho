package br.org.catolicasc.dto;

import br.org.catolicasc.model.Venda;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VendaDTO {
    private Long id;
    private LocalDateTime dateTime;
    private List<ItemVendaDTO> itensVenda;

    public VendaDTO toDTO(Venda venda) {
        VendaDTO dto = new VendaDTO();
        this.id = venda.getId();
        this.dateTime = venda.getDateTime();
        return dto;
    }
}