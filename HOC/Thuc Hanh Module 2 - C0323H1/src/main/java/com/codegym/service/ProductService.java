package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.utils.CSVUtils;
import com.codegym.utils.TypeSort;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService{
    public final static String PATH = "./data/products.csv";
    private static ProductService instance;

    public static ProductService getInstance() {
        if (instance == null) {
            instance = new ProductService();
        }
        return instance;
    }
    @Override
    public List<Product> findAll() {
        List<Product> listProduct = new ArrayList<>();
        List<String> records = CSVUtils.readData(PATH);
        for (String record : records) {
            listProduct.add(Product.parseProduct(record));
        }
        return listProduct;
    }

    @Override
    public void addProduct(Product product) {
        List<Product> products = findAll();
        products.add(product);
        CSVUtils.writeData(PATH, products);
    }

    @Override
    public Product findById(long idProduct) {
        List<Product> products = findAll();
        for (Product product : products) {
            if (product.getIdProduct().equals(idProduct)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void remove(long idProduct) {
        List<Product> products = findAll();
        products.removeIf(id -> id.getIdProduct().equals(idProduct));
        CSVUtils.writeData(PATH, products);
    }

    @Override
    public void update(Product newProduct) {
        List<Product> productList = findAll();
        for (Product product : productList) {
            if (newProduct.getIdProduct().equals(product.getIdProduct())) {
                String name = newProduct.getNameProduct();
                if (name != null && !name.isEmpty()) {
                    product.setNameProduct(newProduct.getNameProduct());
                }
                Integer quantity = newProduct.getQuantity();
                if (quantity != null) {
                    product.setQuantity(quantity);
                }
                Double price = newProduct.getPrice();
                if (price != null) {
                    product.setPrice(price);
                }
                String description = newProduct.getDescription();
                if (description != null && !description.isEmpty()) {
                    product.setDescription(newProduct.getDescription());
                }
                CSVUtils.writeData(PATH, productList);
                break;
            }
        }
    }

    @Override
    public boolean existId(long idProduct) {
        return findById(idProduct) != null;
    }
}
