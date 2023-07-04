package com.codegym.model;

import java.util.List;
import java.util.Objects;

public class Product {
    private Long idProduct;
    private String nameProduct;
    private Double price;
    private Integer quantity;
    private String description;
    private List<Product> products;

    public Product(Long idProduct, String nameProduct, Double price, Integer quantity, String description, List<Product> products) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Product() {
    }

    public Product(Long idProduct, String nameProduct, Double price, Integer quantity, String description) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public int hashCode() {
        return Objects.hash(idProduct, nameProduct, price, quantity, description, products);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(idProduct, product.idProduct) && Objects.equals(nameProduct, product.nameProduct) && Objects.equals(price, product.price) && Objects.equals(quantity, product.quantity) && Objects.equals(description, product.description) && Objects.equals(products, product.products);
    }

    public static Product parseProduct(String rawProduct) {
        String[] arr = rawProduct.split(",");
        Product product = new Product();
        product.setIdProduct(Long.parseLong(arr[0]));
        product.setNameProduct(arr[1]);
        product.setPrice(Double.parseDouble(arr[2]));
        product.setQuantity(Integer.parseInt(arr[3]));
        product.setDescription(arr[4]);
        return product;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s",this.idProduct,this.nameProduct,this.price,this.quantity,this.description);
    }
}
