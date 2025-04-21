package br.org.catolicasc.repository;

import br.org.catolicasc.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findCategoryById(Long id);
}
