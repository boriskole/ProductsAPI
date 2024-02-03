package nl.boriskole.api.service;

import nl.boriskole.api.domain.Product;
import nl.boriskole.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    @Transactional
    public void edit(Product product) {

        Product foundProduct = productRepository.findById(product.getId()).orElseThrow(() -> new IllegalArgumentException("Product with id: " + product.getId() + " does not exist!"));

        if (foundProduct != null) {
            foundProduct.setName(product.getName());
            foundProduct.setPrice(product.getPrice());
            foundProduct.setOutOfStock(product.getOutOfStock());
        }

    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

}
