package com.goga.restapimongodb.service;

import com.goga.restapimongodb.domain.Product;
import com.goga.restapimongodb.dto.ProductDTO;
import com.goga.restapimongodb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void createProduct(ProductDTO productDTO) {
        Product product = new Product(
                productDTO.getId(),
                productDTO.getImagePath(),
                productDTO.getTitle(),
                productDTO.getDescription()
        );

        productRepository.save(product);
    }


    public void updateProduct(Long productId, ProductDTO productDTO) {
        Product product = productRepository.findById(productId).orElse(null);

        if (product != null) {
            product.setTitle(productDTO.getTitle());
            product.setDescription(productDTO.getDescription());
            productRepository.save(product);
        }
    }

    public void deleteProduct(Long productId) {
        Product product = productRepository.findById(productId).orElse(null);

        if (product != null) {
            productRepository.delete(product);
        }
    }
}
