package br.org.catolicasc.service;

import br.org.catolicasc.dto.ProdutoVendaDTO;
import br.org.catolicasc.model.ItemVenda;
import br.org.catolicasc.model.Produto;
import br.org.catolicasc.model.Venda;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import br.org.catolicasc.repository.VendaRepository;

@Service
public class VendaService {

    private final ItemVendaService itemVendaService;
    private final VendaRepository vendaRepository;
    private final ProdutoService produtoService;

    public VendaService(ItemVendaService itemVendaService, VendaRepository vendaRepository, ProdutoService produtoService){
        this.vendaRepository = vendaRepository;
        this.itemVendaService = itemVendaService;
        this.produtoService = produtoService;
    }

    public void criaVenda(){
        vendaRepository.save(new Venda());
    }

    public Venda getVendaPorId(Long id){
        return vendaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Venda não encontrada"));
    }

     public void adicionaProdutoVenda(Long id, ProdutoVendaDTO produtoVendaDTO) {
        Venda venda = getVendaPorId(id);
        Produto produto = produtoService.findProdutoById(produtoVendaDTO.getIdProduto());
        ItemVenda itemVenda = itemVendaService.createItemVenda(venda, produto);
        venda.getVendaList().add(itemVenda);
        vendaRepository.save(venda);
    }

    public void removeItemVenda(Long idVenda, Long idItem) {
        Venda venda = getVendaPorId(idVenda);
        ItemVenda item = itemVendaService.getItemFromListById(venda.getVendaList(), idItem);
        venda.getVendaList().remove(item);
        itemVendaService.deleteItemVendaById(item);
        vendaRepository.save(venda);
    }
}
