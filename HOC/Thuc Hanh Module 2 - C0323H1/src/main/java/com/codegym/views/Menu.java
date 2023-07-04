package com.codegym.views;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static List<Product> products = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void launch() {
        boolean checkAction = true;
        int choice;
        do {
            try {
                menu();
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        ProductView.showProducts();
                        break;
                    case 2:
                        ProductView.addProduct();
                        break;
                    case 3:
                        ProductView.editProduct();
                        break;
                    case 4:
                        ProductView.removeProduct();
                        break;
                    case 5:
                        ProductView.sortProductByPrice();
                        break;
                    case 6:
                        ProductView.showTheMostExpensiveProduct();
                        break;
                    case 7:
                    case 8:
                        break;
                    case 9:
                        System.exit(1);
                    default:
                        System.out.println("Nhập sai, vui lòng nhập lại");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Sai định dạng, nhập lại");
            }
        } while(checkAction);
    }

    public static void menu() {
        System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM ----");
        System.out.println("Chọn chức năng theo số (để tiếp tục)");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Sắp xếp");
        System.out.println("6. Tìm sản phẩm có giá đắt nhất");
        System.out.println("7. Đọc từ file");
        System.out.println("8. Ghi vào file");
        System.out.println("9. Thoát");
        System.out.print("Chọn chức năng: ");
    }
}
