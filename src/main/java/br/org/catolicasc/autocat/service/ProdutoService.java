package br.org.catolicasc.autocat.service;

import br.org.catolicasc.autocat.dto.ProdutoDTO;
import br.org.catolicasc.autocat.model.Produto;
import br.org.catolicasc.autocat.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void cadastraProduto(ProdutoDTO produtoDTO){
        Produto produto = new Produto(produtoDTO.getPreco(), produtoDTO.getQuantidade());
        produtoRepository.save(produto);
    }

    public void excluiProdutoPorId(Long id){
        findProdutoById(id);
        produtoRepository.deleteById(id);
   }

   public Produto atualizaProduto(Long id, ProdutoDTO produto){

        Produto produtoToChange = findProdutoById(id);

        produtoToChange.setQuantidade(produto.getQuantidade());
        produtoToChange.setPreco(produto.getPreco());
        return produtoRepository.save(produtoToChange);
   }

   public Produto findProdutoById(Long id){
       if (id == null)
           throw new IllegalArgumentException("Identificador do produto invalido! ");

       return produtoRepository.findById(id)
               .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));
   }

   public List<Produto> listaProdutos(){
        return produtoRepository.findAll();
   }
}
