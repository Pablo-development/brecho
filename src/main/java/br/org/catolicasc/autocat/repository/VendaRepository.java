package br.org.catolicasc.autocat.repository;

import br.org.catolicasc.autocat.model.ItemVenda;
import br.org.catolicasc.autocat.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
}
