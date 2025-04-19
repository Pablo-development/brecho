package br.org.catolicasc.service;

import br.org.catolicasc.dto.ProductDTO;
import br.org.catolicasc.model.Product;
import br.org.catolicasc.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product registerProduct(ProductDTO productDTO) {
        Product product = new Product(productDTO.getPrice(), productDTO.getQuantity(), productDTO.getCategory());
        return productRepository.save(product);
    }

    public void deleteProductById(Long id) {
        findProductById(id);
        productRepository.deleteById(id);
    }

    public Product updateProduct(Long id, ProductDTO productDTO) {
        Product productToUpdate = findProductById(id);
        productToUpdate.setQuantity(productDTO.getQuantity());
        productToUpdate.setPrice(productDTO.getPrice());
        return productRepository.save(productToUpdate);
    }

    public Product findProductById(Long id) {
        if (id == null)
            throw new IllegalArgumentException("Invalid product identifier!");

        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }

    public List<Product> listProducts() {
        return productRepository.findAll();
    }
}
