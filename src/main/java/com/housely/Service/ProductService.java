package com.housely.Service;

import com.housely.Model.Category.Category;
import com.housely.Model.Product.Product;
import com.housely.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product findById(String id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public List<Product> findByCategoryName(String categoryName) {
        return productRepository.findByCategoryName(categoryName);
    }

    public List<Category> findCategoriesByProductCode(String productCode) {
        return productRepository.findCategoriesByProductCode(productCode);
    }

    public List<Product> findByRoomId(Long roomId) {
        return productRepository.findByRoomId(roomId);
    }

    public void deleteById(String id) {
        productRepository.deleteById(id);
    }

}
