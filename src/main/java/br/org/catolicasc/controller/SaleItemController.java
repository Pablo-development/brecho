package br.org.catolicasc.controller;

import br.org.catolicasc.dto.SaleItemDTO;
import br.org.catolicasc.service.SaleItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sale_item")
public class SaleItemController {

    private final SaleItemService saleItemService;

    public SaleItemController(SaleItemService saleItemService) {
        this.saleItemService = saleItemService;
    }

    @GetMapping
    public ResponseEntity<List<SaleItemDTO>> getAll() {
        List<SaleItemDTO> itemList = saleItemService.getSaleItemList();
        return ResponseEntity.ok().body(itemList);
    }

    @GetMapping("{id}")
    public ResponseEntity<List<SaleItemDTO>> getSoldItemListBySaleId(@PathVariable Long id) {
        List<SaleItemDTO> itemList = saleItemService.getSoldItemsBySaleId(id);
        return ResponseEntity.ok(itemList);
    }
}
