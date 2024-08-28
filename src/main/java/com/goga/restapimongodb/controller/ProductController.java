package com.goga.restapimongodb.controller;

import com.goga.restapimongodb.domain.Product;
import com.goga.restapimongodb.dto.ProductDTO;
import com.goga.restapimongodb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/products", produces = "application/json")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @PostMapping(value = "/product")
    public ResponseEntity saveProduct(@RequestBody ProductDTO productDTO) {
        productService.createProduct(productDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping(value = "/{productId}")
    public ResponseEntity updateProduct(@PathVariable Long productId, @RequestBody ProductDTO productDTO) {
        productService.updateProduct(productId, productDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{productId}")
    public ResponseEntity deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}

