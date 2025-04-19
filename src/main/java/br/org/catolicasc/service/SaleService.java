package br.org.catolicasc.service;

import br.org.catolicasc.dto.ProductItemSaleDTO;
import br.org.catolicasc.model.SaleItem;
import br.org.catolicasc.model.Product;
import br.org.catolicasc.model.Sale;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import br.org.catolicasc.repository.SaleRepository;

@Service
public class SaleService {

    private final SaleItemService saleItemService;
    private final SaleRepository saleRepository;
    private final ProductService productService;

    public SaleService(SaleItemService saleItemService, SaleRepository saleRepository, ProductService productService) {
        this.saleRepository = saleRepository;
        this.saleItemService = saleItemService;
        this.productService = productService;
    }

    public void createSale() {
        saleRepository.save(new Sale());
    }

    public Sale getSaleById(Long id) {
        return saleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sale not found"));
    }

    public void addProductToSale(Long saleId, ProductItemSaleDTO productItemSaleDTO) {
        Sale sale = getSaleById(saleId);
        Product product = productService.findProductById(productItemSaleDTO.getProductId());
        SaleItem saleItem = saleItemService.createSaleItem(sale, product);
        sale.getSaleItemList().add(saleItem);
        saleRepository.save(sale);
    }

    public void removeSaleItem(Long saleId, Long itemId) {
        Sale sale = getSaleById(saleId);
        SaleItem item = saleItemService.getItemFromListById(sale.getSaleItemList(), itemId);
        sale.getSaleItemList().remove(item);
        saleItemService.deleteSaleItemById(item);
        saleRepository.save(sale);
    }
}

