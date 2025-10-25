package com.caiodev.dsecommerce.controllers;

import com.caiodev.dsecommerce.dto.ProductDto;
import com.caiodev.dsecommerce.entities.Product;
import com.caiodev.dsecommerce.repositories.ProductRepository;
import com.caiodev.dsecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id)  {
        ProductDto dto = service.findById(id);
        return dto;
    }

    @GetMapping
    public Page<ProductDto> findAll(Pageable pageable )  {
        return service.findAll(pageable);
    }

    @PostMapping
    public ProductDto insert( @RequestBody ProductDto dto) {
        return service.insert(dto);
    }
}













