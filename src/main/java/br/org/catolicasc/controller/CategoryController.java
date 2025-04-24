package br.org.catolicasc.controller;

import br.org.catolicasc.dto.CategoryDTO;
import br.org.catolicasc.dto.CategoryResponseDTO;
import br.org.catolicasc.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategories(){
        List<CategoryResponseDTO> categoryList = categoryService.findAll();
        return ResponseEntity.ok().body(categoryList);
    }

    @PostMapping("/create")
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CategoryDTO data){
        CategoryResponseDTO category = categoryService.createCategory(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CategoryResponseDTO> updateCategory(@PathVariable Long id, @RequestBody CategoryDTO data){
        CategoryResponseDTO category = categoryService.updateCategory(id, data);
        return ResponseEntity.ok().body(category);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
