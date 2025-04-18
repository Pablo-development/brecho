package br.org.catolicasc.autocat.controller;

import br.org.catolicasc.autocat.dto.ProdutoVendaDTO;
import br.org.catolicasc.autocat.dto.VendaDTO;

import br.org.catolicasc.autocat.model.Venda;
import br.org.catolicasc.autocat.service.VendaService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/vendas")
public class VendaController {
    private final VendaService vendaService;

    public VendaController(VendaService vendaService){
        this.vendaService = vendaService;
    }
    
    @PostMapping("/criaVenda")
    public ResponseEntity<String> criaVenda(){
        vendaService.criaVenda();
        return ResponseEntity.status(HttpStatus.CREATED).body("Venda iniciada com sucesso! ");
    }

    @GetMapping("/retornalistaVenda/{id}")
    public ResponseEntity<Venda> retornalistaVenda(@PathVariable Long id) {
        return ResponseEntity.ok(vendaService.getVendaPorId(id));
    }

    @PostMapping("/adicionaProdutoVenda")
    public ResponseEntity<String> adicionaprodutovenda(@Valid @RequestBody ProdutoVendaDTO produtoVendaDTO) {
        vendaService.adicionaProdutoVenda(produtoVendaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Produto adicionado com sucesso! ");
    }

    @DeleteMapping("/removeItemVendaPorId/{idItem}/{idVenda}")
    public ResponseEntity<Venda> removeProdutoVenda(@PathVariable Long idItem, @PathVariable Long idVenda){
        vendaService.removeItemVenda(idVenda, idItem);
        return ResponseEntity.ok(vendaService.getVendaPorId(idVenda));
    }
}
