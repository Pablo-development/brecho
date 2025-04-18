package br.org.catolicasc.autocat.controller;

import br.org.catolicasc.autocat.dto.ProdutoDTO;
import br.org.catolicasc.autocat.model.Produto;
import br.org.catolicasc.autocat.service.ProdutoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }


    @GetMapping
    public List<Produto> listaProdutos(){
        return produtoService.listaProdutos();
    }

    @PostMapping("/cadastraProduto")
    public ResponseEntity<Produto> cadastraProduto(@RequestBody ProdutoDTO produtoDTO){
        Produto produto = produtoService.cadastraProduto(produtoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @DeleteMapping("/excluiProduto/{id}")
    public ResponseEntity<String> excluiProdutoPorId(@PathVariable Long id){
        try {
            produtoService.excluiProdutoPorId(id);
            return ResponseEntity.ok("Produto excluido com sucesso! ");
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/atualizaProduto/{id}")
    public ResponseEntity<Produto> atualizaProduto(@PathVariable Long id, @RequestBody ProdutoDTO produto){
        return ResponseEntity.ok(produtoService.atualizaProduto(id, produto));
    }
}
