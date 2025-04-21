package br.org.catolicasc.service;

import br.org.catolicasc.dto.CategoryResponseDTO;
import br.org.catolicasc.model.Category;
import br.org.catolicasc.dto.CategoryDTO;
import br.org.catolicasc.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryDTO createCategory(CategoryDTO data) {
        Category category = categoryRepository.save(new Category(data.name()));
        return new CategoryDTO(category.getName());
    }

    public CategoryDTO getCategoryById(Long id) {
        Category category = categoryRepository.findCategoryById(id);
        return new CategoryDTO(category.getName());
    }

    public List<CategoryResponseDTO> findAll() {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList.stream().map(category -> new CategoryResponseDTO(category.getId(), category.getName())).toList();
    }
}
