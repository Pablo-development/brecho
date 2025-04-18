package br.org.catolicasc.autocat.repository;

import br.org.catolicasc.autocat.model.ItemVenda;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemVendaRepository extends JpaRepository<ItemVenda, Long> {
    @Query("SELECT i FROM ItemVenda i WHERE i.produto.id = :idProduto")
    public List<ItemVenda> getItemVendaListByIdItem(@Param("idProduto") Long idProduto);
}
