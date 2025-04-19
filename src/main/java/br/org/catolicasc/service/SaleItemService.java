package br.org.catolicasc.service;

import br.org.catolicasc.dto.ItemSaleDTO;
import br.org.catolicasc.model.SaleItem;
import br.org.catolicasc.model.Product;
import br.org.catolicasc.model.Sale;
import br.org.catolicasc.repository.SaleItemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleItemService {

    private final SaleItemRepository saleItemRepository;

    public SaleItemService(SaleItemRepository saleItemRepository) {
        this.saleItemRepository = saleItemRepository;
    }

    public List<ItemSaleDTO> getSaleItemList() {
        return saleItemRepository.findAll().stream().map(ItemSaleDTO::new).toList();
    }

    public SaleItem createSaleItem(Sale sale, Product product) {
        SaleItem saleItem = new SaleItem(sale, product);
        saleItemRepository.save(saleItem);
        return saleItem;
    }

    public void deleteSaleItemById(SaleItem saleItem) {
        saleItemRepository.delete(saleItem);
    }

    public SaleItem getItemFromListById(List<SaleItem> list, Long id) {
        return list.stream().filter(saleItem -> saleItem.getIdItem().equals(id)).findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Item not found in sale"));
    }

    public List<ItemSaleDTO> getSoldItemsBySaleId(Long id) {
        return saleItemRepository.getItemVendaListByIdItem(id)
                .stream().map(ItemSaleDTO::new).toList();
    }
}
