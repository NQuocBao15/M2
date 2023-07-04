package views;

import model.Student;
import utils.AppUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    static List<Student> productList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void view() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN ----");
            System.out.println("Chọn chức năng theo số (để tiếp tục)");
            System.out.println("1. Xem danh sách sinh viên");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Thoát");
            System.out.println("Chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    StudentView.showStudentsList();
                    break;
                case 2:
                    StudentView.addStudent();
                    break;
                case 3:
                    StudentView.editStudent();
                    break;
                case 4:
                    StudentView.removeStudent();
                    break;
                case 5:
                    StudentView.sortAveragePointView();
                    break;
                case 6, 7:
                    break;
                case 8:
                    AppUtils.exit();
            }
        } while (choice != 8);
    }
}
