package br.org.catolicasc.repository;

import br.org.catolicasc.model.SaleItem;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleItemRepository extends JpaRepository<SaleItem, Long> {
    @Query("SELECT i FROM SaleItem i WHERE i.product.id = :idProduct")
    public List<SaleItem> getItemVendaListByIdItem(@Param("idProduct") Long idProduct);
}
