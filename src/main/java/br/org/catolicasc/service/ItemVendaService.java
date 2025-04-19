package br.org.catolicasc.service;

import br.org.catolicasc.dto.ItemVendaDTO;
import br.org.catolicasc.model.ItemVenda;
import br.org.catolicasc.model.Produto;
import br.org.catolicasc.model.Venda;
import br.org.catolicasc.repository.ItemVendaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemVendaService {

    private final ItemVendaRepository itemVendaRepository;

    public ItemVendaService(ItemVendaRepository itemVendaRepository) {
        this.itemVendaRepository = itemVendaRepository;
    }


    public List<ItemVendaDTO> getItemVendaList(){
        return itemVendaRepository.findAll().stream().map(ItemVendaDTO::new).toList();
    }

    public ItemVenda criaItemVenda(Venda venda, Produto produto){
        ItemVenda itemVenda = new ItemVenda(venda, produto);
        itemVendaRepository.save(itemVenda);
        return itemVenda;
    }

    public void deleteItemVendaById(ItemVenda itemVenda){
        itemVendaRepository.delete(itemVenda);
    }

    public ItemVenda getItemFromListById(List<ItemVenda> list, Long id){
        return list.stream().filter(itemVenda -> itemVenda.getIdItem().equals(id)).findFirst()
                .orElseThrow(()-> new EntityNotFoundException("Item não encontrado na venda"));
    }

    public List<ItemVendaDTO> getSoldItensById(Long id) {
        return itemVendaRepository.getItemVendaListByIdItem(id)
                .stream().map(ItemVendaDTO::new).toList();
    }
}
