package br.org.catolicasc.controller;


import br.org.catolicasc.dto.ItemVendaDTO;
import br.org.catolicasc.service.ItemVendaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/relatorio")
public class ItemVendaController {

    private final ItemVendaService itemVendaService;

    public ItemVendaController(ItemVendaService itemVendaService) {
        this.itemVendaService = itemVendaService;
    }

    @GetMapping
    public ResponseEntity<List<ItemVendaDTO>> listar() {
        List<ItemVendaDTO> itemList = itemVendaService.getItemVendaList();
        return ResponseEntity.ok().body(itemList);
    }

    @GetMapping("{id}")
    public ResponseEntity<List<ItemVendaDTO>> getSoldItemListById(@PathVariable Long id){
        List<ItemVendaDTO> itemList = itemVendaService.getSoldItensById(id);
        return ResponseEntity.ok(itemList);
    }
}
