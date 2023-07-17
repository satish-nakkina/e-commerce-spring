package com.assignment.controller;

import com.assignment.dto.ProductDTO;
import com.assignment.service.ProductInterface;
import com.assignment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductInterface productInterface;

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productInterface.getAllProducts();
    }
}