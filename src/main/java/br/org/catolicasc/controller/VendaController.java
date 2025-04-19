package br.org.catolicasc.controller;

import br.org.catolicasc.dto.ProdutoVendaDTO;

import br.org.catolicasc.dto.VendaDTO;
import br.org.catolicasc.model.Venda;
import br.org.catolicasc.service.VendaService;

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


    //ta feio esse codigo, mas deu preguiça de ajustar agora
    @GetMapping("/getSaleList/{id}")
    public ResponseEntity<Venda> getVendaList(@PathVariable Long id) {
        Venda venda = vendaService.getVendaPorId(id);
        return ResponseEntity.ok(venda);
    }

    @PostMapping("/criaVenda")
    public ResponseEntity<String> createVenda(){
        vendaService.criaVenda();
        return ResponseEntity.status(HttpStatus.CREATED).body("Venda iniciada com sucesso! ");
    }

    @PostMapping("/adicionaProdutoVenda/venda/{id}")
    public ResponseEntity<String> addProdutoVenda(@PathVariable Long id, @RequestBody @Valid ProdutoVendaDTO produtoVendaDTO) {
        vendaService.adicionaProdutoVenda(id, produtoVendaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Produto adicionado com sucesso! ");
    }

    @DeleteMapping("/removeItemVendaPorId/venda/{idItem}/item/{idVenda}")
    public ResponseEntity<Venda> removeItemFromVenda(@PathVariable Long idItem, @PathVariable Long idVenda){
        vendaService.removeItemVenda(idVenda, idItem);
        return ResponseEntity.ok(vendaService.getVendaPorId(idVenda));
    }
}
