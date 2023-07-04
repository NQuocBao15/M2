package test.service;

import test.Config;
import test.FileUtils;
import test.Product;

import java.util.List;

public class ProductService {
    private final String pathProduct = "./data/product.txt";
    public List<Product> getAllProducts(){
        return FileUtils.readFile(pathProduct, Config.TYPE_PRODUCT);
    }

    public Product findProductById(long idProduct) {
        List<Product> products = FileUtils.readFile(pathProduct, Config.TYPE_PRODUCT);
        for (Product p : products) {
            if (p.getId() == idProduct) {
                return p;
            }
        }
        return null;
    }

    public void updateProductById(long idProduct, Product product) {
        List<Product> products = FileUtils.readFile(pathProduct, Config.TYPE_PRODUCT);
        for (Product p : products) {
            if (p.getId() == idProduct) {
                p.setName(product.getName());
                p.setDescription(product.getDescription());
                p.setPrice(product.getPrice());
                p.setCreateAt(product.getCreateAt());
            }
        }
        FileUtils.writeFile(pathProduct, products);

    }

    public void deleteProductById(long idProduct) {
        List<Product> products = FileUtils.readFile(pathProduct, Config.TYPE_PRODUCT);
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == idProduct) {
                products.remove(i);
                break;
            }
        }
        FileUtils.writeFile(pathProduct, products);
    }

    public void addProduct(Product product){
        List<Product> products = FileUtils.readFile(pathProduct, Config.TYPE_PRODUCT);
        products.add(product);

        FileUtils.writeFile(pathProduct, products);
    }
}
