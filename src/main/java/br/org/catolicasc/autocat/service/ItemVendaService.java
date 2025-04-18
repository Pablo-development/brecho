package br.org.catolicasc.autocat.service;

import br.org.catolicasc.autocat.model.ItemVenda;
import br.org.catolicasc.autocat.model.Produto;
import br.org.catolicasc.autocat.model.Venda;
import br.org.catolicasc.autocat.repository.ItemVendaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemVendaService {

    private final ItemVendaRepository itemVendaRepository;

    public ItemVendaService(ItemVendaRepository itemVendaRepository) {
        this.itemVendaRepository = itemVendaRepository;
    }

    public ItemVenda criaItemVenda(Venda venda, Produto produto){
        ItemVenda itemVenda = new ItemVenda(venda, produto);
        itemVendaRepository.save(itemVenda);
        return itemVenda;
    }

    public void deleteItemVendaById(ItemVenda itemVenda){
        itemVendaRepository.delete(itemVenda);
    }

    public ItemVenda getItemById(List<ItemVenda> list, Long id){
        return list.stream().filter(itemVenda -> itemVenda.getIdItem().equals(id)).findFirst()
                .orElseThrow(()-> new EntityNotFoundException("Item não encontrado na venda"));
    }

}
