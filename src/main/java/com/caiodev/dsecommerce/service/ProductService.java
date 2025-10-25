package com.caiodev.dsecommerce.service;

import com.caiodev.dsecommerce.dto.ProductDto;
import com.caiodev.dsecommerce.entities.Product;
import com.caiodev.dsecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDto findById(Long id){
        Product product =  repository.findById(id).get();
        return new ProductDto(product);
    }

    @Transactional(readOnly = true)
    public Page<ProductDto> findAll(Pageable pageable){
        Page<Product> result =  repository.findAll(pageable);
        return result.map(x-> new ProductDto(x));
    }
    @Transactional
    public ProductDto insert(ProductDto dto){

         Product entity = new Product();
         entity.setName(dto.getName());
         entity.setDescription(dto.getDescription());
         entity.setImgUrl(dto.getImgUrl());
         entity.setPrice(dto.getPrice());

         entity = repository.save(entity);

         return new ProductDto(entity);
    }

}




































