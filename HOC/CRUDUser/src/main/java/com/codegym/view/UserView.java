package com.codegym.view;

import com.codegym.model.Config;
import com.codegym.model.EGender;
import com.codegym.model.ERole;
import com.codegym.model.User;
import com.codegym.service.UserService;
import com.codegym.utils.FileUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class UserView {
    private static final int INPUT_USER_ADD = 1;
    private static final int INPUT_USER_EDIT = 2;
    private static final Scanner scanner = new Scanner(System.in);
    private List<User> userList;
    private UserService userService = new UserService();
    private final String path = "./data/user.txt";
    public void launch() {
        boolean checkActionMenu;
        do {
            checkActionMenu = true;
            System.out.println("===================================================");
            System.out.println("||              MENU QUAN LY NGUOI DUNG          ||");
            System.out.println("|| --------------------------------------------- ||");
            System.out.println("|| Nhấn 1: Xem toàn bộ thông tin của nguoi dung  ||");
            System.out.println("|| Nhấn 2: Thêm nguoi dung                       ||");
            System.out.println("|| Nhấn 3: Sửa thông tin nguoi dung              ||");
            System.out.println("|| Nhấn 4: Xóa nguoi dung                        ||");
            System.out.println("|| Nhấn 5: Tìm người dùng theo tên               ||");
            System.out.println("|| Nhấn 6: Tìm người dùng theo địa chỉ           ||");
            System.out.println("|| Nhấn 7: Tìm người dùng theo ngày sinh         ||");
            System.out.println("|| Nhấn 8: Tìm người dùng theo năm sinh          ||");
            System.out.println("|| Nhấn 9: Tìm người dùng theo 1 khoảng thời gian||");
            System.out.println("|| Nhấn bất kì: Thoát chương trình               ||");
            System.out.println("===================================================");
            int actionMenu = Integer.parseInt(scanner.nextLine());
            switch (actionMenu) {
                case 1:
                    userList = userService.getAllUsers();
                    showUser();
                    break;
                case 2:
                    addUser();
                    break;
                case 3:
                    editUserByID();
                    break;
                case 4:
                    deleteUserById();
                    break;
                case 5:

                    break;
                default:
                    System.exit(1);
            }
            boolean repeatMenu;
            do {
                repeatMenu = true;
                System.out.println("Ban có muốn tiếp tục hay không: ");
                System.out.println("Nhập 1. Tiếp tục");
                System.out.println("Nhập 2. Kết thúc");
                int actionMenuContinue = Integer.parseInt(scanner.nextLine());
                switch (actionMenuContinue) {
                    case 1:
                        checkActionMenu = true;
                        repeatMenu = false;
                        break;
                    case 2:
                        checkActionMenu = false;
                        repeatMenu = false;
                        break;
                    default:
                        System.out.println("Không đúng lệnh, vui lòng nhập lại:");
                }
            } while (repeatMenu);
        } while (checkActionMenu);
    }

    public void showUser() {
        System.out.printf("%-5s | %-15s | %-15s | %-10s | %-10s | %-15s\n",
                "ID", "TEN", "DIA CHI", "GIOI TINH", "VAI TRO", "NGAY SINH");
        for (int i = 0; i < userList.size(); i++) {
            User user =userList.get(i);
            System.out.printf("%-5s | %-15s | %-15s | %-10s | %-10s | %-15s\n",
                    user.getId(),user.getName(),user.getAddress(),user.geteGender(),user.geteRole(),user.getDob());
        }
    }

    private void editUserByID() {
        showUser();

        System.out.println("Nhap ID nguoi dung can sua");
        long idUser = Long.parseLong(scanner.nextLine());
        User userEdit = findUserById(userList, idUser);
        if (userEdit != null) {
            userService.updateUserById(idUser, userEdit);
        }
        System.out.println("Da sua nguoi dung");
    }

    private void deleteUserById() {
        System.out.println("Nhap ID nguoi dung can xoa");
        long idUserDel = Long.parseLong(scanner.nextLine());
        User userDel = findUserById(userList, idUserDel);
        if (userDel != null) {
            userService.deleteUserById(idUserDel);
        }
        System.out.println("Da xoa nguoi dung");
    }

    private User findUserByName() {
        String name = inputNameUser();
        userService.findUserByName(name);
        System.out.println();
    }

    private User findUserById(List<User> userList, long idUser) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == idUser) {
                return userList.get(i);
            }
        }
        return null;
    }

    private void addUser() {
        long id = System.currentTimeMillis()%1000;
        String name = inputNameUser();
        String address = inputAddressUser();
        LocalDate dob = inputDOBUser();
        User user = new User(id, name, address, EGender.MALE, ERole.USER, dob);
        setGender(user);
        setRole(user);
        userList = FileUtils.readFile(path, Config.TYPE_USER);
        userList.add(user);

        FileUtils.writeFile(path,userList);
        showUser();
    }

    private LocalDate inputDOBUser() {
        System.out.println("Nhập ngày sinh (theo định dạng dd/MM/yyyy):");
        String input = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return LocalDate.parse(input, formatter);
    }

    private static void setGender(User user) {
        boolean isTrue = true;
        int option;
        menuSetGender();
        do {
            try {
                option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1 -> {
                        user.seteGender(EGender.MALE);
                        isTrue = false;
                    }

                    case 2 -> {
                        user.seteGender(EGender.FEMALE);
                        isTrue = false;
                    }

                    default -> {
                        System.out.println("Lựa chọn sai. Vui lòng nhập lại!");
                    }
                }
            } catch (Exception ex) {
                System.out.println("Sai cú pháp. Vui lòng nhập lại!");
            }
        } while (isTrue);
    }

    private static void menuSetGender() {
        System.out.println("═════════ CHỌN QUYỀN ═════════");
        System.out.println("║          1. NAM            ║");
        System.out.println("║          2. NỮ             ║");
        System.out.println("══════════════════════════════");
        System.out.println("Nhập lựa chọn: ");
    }

    private String inputAddressUser() {
        System.out.println("Nhap dia chi nguoi dung");
        return scanner.nextLine();
    }

    private String inputNameUser() {
        System.out.println("Nhap ten nguoi dung");
        return scanner.nextLine();
    }

    private static void setRole(User user) {
        boolean isTrue = true;
        int option;
        menuSetRole();
        do {
            try {
                option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1 -> {
                        user.seteRole(ERole.ADMIN);
                        isTrue = false;
                    }
                    case 2 -> {
                        user.seteRole(ERole.EDITOR);
                        isTrue = false;
                    }
                    case 3 -> {
                        user.seteRole(ERole.USER);
                        isTrue = false;
                    }
                    case 4 -> {
                        user.seteRole(ERole.GUEST);
                        isTrue = false;
                    }

                    default -> {
                        System.out.println("Lựa chọn sai. Vui lòng nhập lại!");
                    }
                }
            } catch (Exception ex) {
                System.out.println("Sai cú pháp. Vui lòng nhập lại!");
            }
        } while (isTrue);
    }

    private static void menuSetRole() {
        System.out.println("═════════ CHỌN QUYỀN ═════════");
        System.out.println("║          1. ADMIN          ║");
        System.out.println("║          2. EDITOR         ║");
        System.out.println("║          3. USER           ║");
        System.out.println("║          4. GUEST          ║");
        System.out.println("══════════════════════════════");
        System.out.println("Nhập lựa chọn: ");
    }
}
