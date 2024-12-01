package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepository;

@Service
public class ProductService {

	 @Autowired
	    private ProductRepository productRepository;

	    public Page<Product> getAllProducts(int page) {
	    	int adjustedPage = page -2;
	    	if(adjustedPage < 0) {
	    		adjustedPage = 0;
	    	}
	        return productRepository.findAll(PageRequest.of(page, 10));
	    }

	    public Product createProduct(Product product) {
	        return productRepository.save(product);
	    }

	    public Optional<Product> getProductById(Long id) {
	        return productRepository.findById(id);
	    }

	    public Product updateProduct(Long id, Product product) {
	        product.setId(id);
	        return productRepository.save(product);
	    }

	    public void deleteProduct(Long id) {
	        productRepository.deleteById(id);
	    }
}
