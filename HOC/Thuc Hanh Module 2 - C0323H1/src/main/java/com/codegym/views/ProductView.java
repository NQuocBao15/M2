package com.codegym.views;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.ProductService;
import com.codegym.service.SortPriceASC;
import com.codegym.utils.CheckUtils;
import com.codegym.utils.Status;

import java.util.List;
import java.util.Scanner;

public class ProductView {
    public static IProductService productService = new ProductService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void showProducts() {
        System.out.println();
        System.out.println("══════════════════════════════════════ Danh Sách Sản Phẩm ═════════════════════════════════════════");
        System.out.printf("%-12s %-20s %-20s %-20s %-20s\n", "ID", "Tên Sản Phẩm", "Giá", "Số lượng", "Mô tả");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────");
        for (Product product : productService.findAll()) {
            System.out.printf("%-12s %-20s %-20s %-20s %-20s\n",
                    product.getIdProduct(),
                    product.getNameProduct(),
                    CheckUtils.doubleToVND(product.getPrice()),
                    product.getQuantity(),
                    product.getDescription());
        }
        System.out.println("═══════════════════════════════════════════════════════════════════════════════════════════════════");
        CheckUtils.pressEnterToContinue();
    }

    public static void addProduct() {
        System.out.println("---- Thêm sản phẩm ----");
        Long productID = System.currentTimeMillis() / 10000;
        String name = inputName(Status.ADD);
        Double price = inputPrice(Status.ADD);
        Integer quantity = inputQuantity(Status.ADD);
        String description = inputDescription(Status.ADD);
        Product product = new Product(productID, name, price , quantity, description);
        productService.addProduct(product);
        System.out.println("Đã thêm thành công");
        showProducts();
    }
    public static Long inputIDProduct(Status status) {
        long idProduct;
        switch (status) {
            case EDIT -> System.out.println("Nhập ID sản phẩm cần sửa: ");
            case REMOVE -> System.out.println("Nhập ID sản phẩm cần xóa: ");
        }
        System.out.print("==>");
        boolean flag = true;
        do {
            idProduct = CheckUtils.retryParseLong();
            boolean exist = productService.existId(idProduct);
            switch (status) {
                case EDIT, REMOVE -> {
                    if (!exist) {
                        System.out.println("Không tìm thấy ID, Vui lòng nhập lại");
                        System.out.print("==> ");
                    }
                    flag = !exist;
                }
            }
        } while (flag);
        return idProduct;
    }

    private static int inputQuantity(Status status) {
        int quantity;
        switch (status) {
            case ADD -> System.out.println("Nhập số lượng sản phẩm: ");
            case EDIT -> System.out.println("Nhập số lượng sản phẩm cần sửa: ");
        }
        System.out.print("==> ");
        boolean flag = true;
        do {
            quantity = CheckUtils.retryParseInt();
            boolean exist = (quantity > 0);
            switch (status) {
                case ADD, EDIT, REMOVE -> {
                    if (!exist) {
                        System.out.println("Bạn nhập sai định dạng (Số lượng phải lớn hơn 1 )");
                        System.out.print("==> ");
                    }
                    flag = !exist;
                }
            }
        } while (flag);
        return quantity;
    }

    public static String inputName(Status status) {
        String name;
        switch (status) {
            case ADD -> System.out.println("Nhập tên sản phẩm: ");
            case EDIT -> System.out.println("Nhập tên sản phẩm muốn sửa: ");
        }
        System.out.print("==> ");
        boolean flag = true;
        do {
            name = scanner.nextLine().trim();
            boolean exist = (!name.isEmpty());
            switch (status) {
                case ADD, EDIT -> {
                    if (!exist) {
                        System.out.println("Bạn nhập sai định dạng, vui lòng nhập lại: ");
                        System.out.print("==> ");
                    }
                    flag = !exist;
                }
            }
        } while (flag);
        return name;
    }

    public static String inputDescription(Status status) {
        String description;
        switch (status) {
            case ADD -> System.out.println("Nhập mô tả sản phẩm: ");
            case EDIT -> System.out.println("Nhập mô tả sản phẩm muốn sửa: ");
        }
        System.out.print("==> ");
        boolean flag = true;
        do {
            description = scanner.nextLine().trim();
            boolean exist = (!description.isEmpty());
            switch (status) {
                case ADD, EDIT -> {
                    if (!exist) {
                        System.out.println("Bạn nhập sai định dạng, vui lòng nhạp lại: ");
                        System.out.print("==> ");
                    }
                    flag = !exist;
                }
            }
        } while (flag);
        return description;
    }

    public static double inputPrice(Status status) {
        double price;
        switch (status) {
            case ADD -> System.out.println("Nhập giá sản phẩm: ");
            case EDIT -> System.out.println("Nhập giá sản phẩm cần sửa: ");
        }
        System.out.print("==> ");
        boolean flag = true;
        do {
            price = CheckUtils.retryParseDouble();
            boolean exist = (price >= 1000);
            switch (status) {
                case ADD, EDIT, REMOVE -> {
                    if (!exist) {
                        System.out.println("Nhập sai định dạng (Số tiền phải lớn hơn 1000đ)");
                        System.out.print("==> ");
                    }
                    flag = !exist;
                }
            }
        } while (flag);
        return price;
    }

    public static void editProduct() {
        boolean flag = true;
        showProducts();
        System.out.println("Nhập ID sản phẩm: ");
        System.out.print("==> ");
        long id = CheckUtils.retryParseLong();
        if (productService.existId(id)) {
            System.out.println("Sửa sản phẩm");
            System.out.println("1. Sửa tên sản phẩm");
            System.out.println("2. Sửa giá sản phẩm");
            System.out.println("3. Sửa số lượng sản phẩm");
            System.out.println("4. Sửa mô tả sản phẩm");
            System.out.println("0. Quay lại quản lý sản phẩm");
            System.out.print("Chọn chức năng: ");
            try {
                Product newProduct = new Product();
                newProduct.setIdProduct(id);
                do {
                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            editName(newProduct);
                            break;
                        case 2:
                            editPrice(newProduct);
                            break;
                        case 3:
                            editQuantity(newProduct);
                            break;
                        case 4:
                            editDescription(newProduct);
                        case 0:
                            Menu.launch();
                            break;
                        default:
                            System.out.println("Nhập sai vui lòng nhập lại: ");
                            System.out.print("==> ");
                            flag = false;
                    }
                } while (!flag);
            } catch (Exception e) {
                System.out.println();
            }
        } else {
            System.out.println("Không tìm thấy ID sản phẩm");
        }
    }

    public static void editName(Product newProduct) {
        String name = inputName(Status.EDIT);
        newProduct.setNameProduct(name);
        productService.update(newProduct);
        System.out.println("Tên sản phẩm đã được cập nhập");
        showProducts();
    }

    public static void editPrice(Product newProduct) {
        Double price =  inputPrice(Status.EDIT);
        newProduct.setPrice(price);
        productService.update(newProduct);
        System.out.println("Giá sản phẩm đã được cập nhập");
        showProducts();

    }

    public static void editQuantity(Product newProduct) {
        int quantity = inputQuantity(Status.EDIT);
        newProduct.setQuantity(quantity);
        productService.update(newProduct);
        System.out.println("Số lượng sẩn phẩm đã được cập nhập");
        showProducts();
    }

    public static void editDescription(Product newProduct) {
        String description = inputDescription(Status.EDIT);
        newProduct.setDescription(description);
        productService.update(newProduct);
        System.out.println("Mô tả sẩn phẩm đã được cập nhập");
        showProducts();
    }

    public static void removeProduct() {
        try {
            boolean flag = true;
            showProducts();
            Long id = inputIDProduct(Status.REMOVE);
            System.out.println("Xóa sản phẩm");
            System.out.println("1. Đồng ý");
            System.out.println("2. Quay lại");
            System.out.print("Chọn chức năng: ");
            do {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> {
                        productService.remove(id);
                        System.out.println("Sản phẩm đã được xóa");
                        showProducts();
                        Menu.launch();
                    }
                    case 2 -> Menu.launch();
                    default -> {
                        System.out.println("Nhập sai, vui lòng nhập lại");
                        System.out.print("==> ");
                        flag = false;
                    }
                }
            } while (!flag);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private static Product findTheMostExpensiveProduct(List<Product> products) {
        Product maxPriceProduct = products.get(0);
        for (int i = 1; i < products.size(); i++) {
            Product currentProduct = products.get(i);
            if (currentProduct.getPrice() > maxPriceProduct.getPrice()) {
                maxPriceProduct = currentProduct;
            }
        }
        return maxPriceProduct;
    }

    public static void showTheMostExpensiveProduct() {
        Product product = findTheMostExpensiveProduct(productService.findAll());
        System.out.println("══════════════════════════════════════ Danh Sách Sản Phẩm ═════════════════════════════════════════");
        System.out.printf("%-12s %-20s %-20s %-20s\n", "ID", "Tên Sản Phẩm", "Giá", "Số lượng");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.printf("%-12s %-20s %-20s %-20s\n",
                product.getIdProduct(),
                product.getNameProduct(),
                CheckUtils.doubleToVND(product.getPrice()),
                product.getQuantity());
        System.out.println("═══════════════════════════════════════════════════════════════════════════════════════════════════");
        CheckUtils.pressEnterToContinue();
    }
    private static void showSortList(List<Product> products) {
        System.out.println("══════════════════════════════════════ Danh Sách Sản Phẩm ═════════════════════════════════════════");
        System.out.printf("%-12s %-20s %-20s %-20s\n", "ID", "Tên Sản Phẩm", "Giá", "Số lượng");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────");
        for (Product product : products) {
            System.out.printf("%-12s %-20s %-20s %-20s\n",
                    product.getIdProduct(),
                    product.getNameProduct(),
                    CheckUtils.doubleToVND(product.getPrice()),
                    product.getQuantity());
        }
        System.out.println("═══════════════════════════════════════════════════════════════════════════════════════════════════");
        CheckUtils.pressEnterToContinue();
    }

    public static void sortProductByPrice() {
        try {
            boolean flag = true;
            int choice;
            System.out.println("Sắp xếp theo giá");
            System.out.println("1. Sắp xếp theo thứ tự tăng dần");
            System.out.println("2. Quay lại");
            System.out.print("Chọn chức năng: ");
            do {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        sortPriceASC();
                        break;
                    case 2:
                        Menu.launch();
                    default:
                        System.out.println("Lựa chọn không hợp lệ");
                        System.out.print("==>");
                        flag = false;
                }
            } while (!flag);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    private static void sortPriceASC() {
        List<Product> products = productService.findAll();
        SortPriceASC sortByPriceASC = new SortPriceASC();
        products.sort(sortByPriceASC);
        showSortList(products);
    }
}
