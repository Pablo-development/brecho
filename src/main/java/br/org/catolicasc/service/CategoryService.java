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

    public CategoryResponseDTO createCategory(CategoryDTO data) {
        Category category = categoryRepository.save(new Category(data.name()));
        return new CategoryResponseDTO(category.getId(), category.getName());
    }

    private Category getCategoryById(Long id) {
        return categoryRepository.findCategoryById(id);
    }

    public List<CategoryResponseDTO> findAll() {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList.stream().map(category -> new CategoryResponseDTO(category.getId(), category.getName())).toList();
    }

    public CategoryResponseDTO updateCategory(Long id, CategoryDTO category){
        Category categoryToChange = categoryRepository.findCategoryById(id);
        categoryToChange.setName(category.name());
        categoryRepository.save(categoryToChange);
        return new CategoryResponseDTO(categoryToChange.getId(), categoryToChange.getName());
    }

    public void deleteCategory(Long id){
        categoryRepository.delete(getCategoryById(id));
    }
}
