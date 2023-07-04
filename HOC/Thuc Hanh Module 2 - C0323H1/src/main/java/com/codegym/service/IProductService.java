package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.utils.TypeSort;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void addProduct(Product product);
    Product findById(long idProduct);
    void remove(long idProduct);
    void update(Product newProduct);
    boolean existId(long idProduct);
}
