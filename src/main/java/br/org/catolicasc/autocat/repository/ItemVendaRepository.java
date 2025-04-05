package br.org.catolicasc.autocat.repository;

import br.org.catolicasc.autocat.model.ItemVenda;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemVendaRepository extends JpaRepository<ItemVenda, Long> {
    @Query("SELECT i FROM ItemVenda i WHERE i.venda.id = :venda_id")
    public List<ItemVenda> findItemVendaByIdItem(@Param(("venda_id")) Long idVenda);
}
