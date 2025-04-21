package br.org.catolicasc.dto;

import br.org.catolicasc.model.Sale;
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
public class SaleDTO {
    private Long id;
    private LocalDateTime dateTime;
    private List<SaleItemDTO> saleItemList;

    public SaleDTO toDTO(Sale sale) {
        SaleDTO dto = new SaleDTO();
        this.id = sale.getId();
        this.dateTime = sale.getDateTime();
        return dto;
    }
}