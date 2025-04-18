package br.org.catolicasc.autocat.controller;


import br.org.catolicasc.autocat.dto.ItemVendaDTO;
import br.org.catolicasc.autocat.model.ItemVenda;
import br.org.catolicasc.autocat.service.ItemVendaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/relatorio")
public class RelatorioController {

    private final ItemVendaService itemVendaService;

    public RelatorioController(ItemVendaService itemVendaService) {
        this.itemVendaService = itemVendaService;
    }

    @GetMapping("{id}")
    public ResponseEntity<List<ItemVendaDTO>> getItemList(@PathVariable Long id){
        List<ItemVendaDTO> itemList = itemVendaService.getSoldItensById(id);
        return ResponseEntity.ok(itemList);
    }
}
