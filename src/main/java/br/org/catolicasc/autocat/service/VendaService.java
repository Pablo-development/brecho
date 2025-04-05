package br.org.catolicasc.autocat.service;

import br.org.catolicasc.autocat.dto.ProdutoVendaDTO;
import br.org.catolicasc.autocat.dto.VendaDTO;
import br.org.catolicasc.autocat.model.ItemVenda;
import br.org.catolicasc.autocat.model.Produto;
import br.org.catolicasc.autocat.model.Venda;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import br.org.catolicasc.autocat.repository.VendaRepository;

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

    public VendaDTO getVendaList(Long id) {
        return new VendaDTO(getVendaPorId(id));
    }

     public void adicionaProdutoVenda(ProdutoVendaDTO produtoVendaDTO) {
        Venda venda = getVendaPorId(produtoVendaDTO.getIdVenda());
        Produto produto = produtoService.findProdutoById(produtoVendaDTO.getIdProduto());
        ItemVenda itemVenda = itemVendaService.criaItemVenda(venda, produto);
        venda.getVendaList().add(itemVenda);
        vendaRepository.save(venda);
    }

    public void removeItemVenda(Long idVenda, Long idItem) {
        Venda venda = getVendaPorId(idVenda);
        ItemVenda item = itemVendaService.getItemById(venda.getVendaList(), idItem);
        venda.getVendaList().remove(item);
        itemVendaService.deleteItemVendaById(item);
        vendaRepository.save(venda);
    }
}
