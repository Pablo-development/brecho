package br.org.catolicasc.autocat.controller;


import br.org.catolicasc.autocat.dto.ItemDTO;
import br.org.catolicasc.autocat.service.ItemVendaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/relatorios")
public class RelatorioController {

    private ItemVendaService itemVendaService;

    public RelatorioController(ItemVendaService itemVendaService) {
        this.itemVendaService = itemVendaService;
    }


    //implementar, fiquei com preguiça
    @GetMapping("/produto/vendas/{id}")
    public List<ItemDTO> getItemList(@PathVariable Long id){
        return ResponseEntity.ok(itemVendaService.getItemListById(id).stream().toList());
    }
}
