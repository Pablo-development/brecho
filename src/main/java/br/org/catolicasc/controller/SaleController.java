package br.org.catolicasc.controller;

import br.org.catolicasc.dto.ProductItemSaleDTO;
import br.org.catolicasc.model.Sale;
import br.org.catolicasc.service.SaleService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales")
public class SaleController {
    private final SaleService saleService;

    public SaleController(SaleService saleService){
        this.saleService = saleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sale> getSaleById(@PathVariable Long id) {
        Sale sale = saleService.getSaleById(id);
        return ResponseEntity.ok(sale);
    }

    @PostMapping
    public ResponseEntity<String> createSale(){
        saleService.createSale();
        return ResponseEntity.status(HttpStatus.CREATED).body("Sale successfully started!");
    }

    @PostMapping("/{id}/items")
    public ResponseEntity<String> addProductToSale(@PathVariable Long id, @RequestBody @Valid ProductItemSaleDTO productItemSaleDTO) {
        saleService.addProductToSale(id, productItemSaleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Product successfully added!");
    }

    @DeleteMapping("/{saleId}/items/{itemId}")
    public ResponseEntity<Sale> removeItemFromSale(@PathVariable Long saleId, @PathVariable Long itemId){
        saleService.removeSaleItem(saleId, itemId);
        return ResponseEntity.ok(saleService.getSaleById(saleId));
    }
}
