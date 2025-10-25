package com.caiodev.dsecommerce.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name="tb_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;


    @ManyToMany(mappedBy = "categories")
    private Set<Product> products = new HashSet<>();

    public Category(){

    }

    public Category(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public void setName(String name) {
        this.name = name;
    }
}
