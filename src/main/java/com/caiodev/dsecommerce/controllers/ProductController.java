package com.caiodev.dsecommerce.controllers;

import com.caiodev.dsecommerce.dto.ProductDto;
import com.caiodev.dsecommerce.entities.Product;
import com.caiodev.dsecommerce.repositories.ProductRepository;
import com.caiodev.dsecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto>  findById(@PathVariable Long id)  {
        ProductDto dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<ProductDto>> findAll(Pageable pageable )  {
        Page<ProductDto> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ProductDto> insert( @RequestBody ProductDto dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping (value = "/{id}")
    public ResponseEntity<ProductDto>  updateById(@PathVariable Long id, @RequestBody ProductDto dto)  {
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }
    @DeleteMapping (value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id)  {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}













