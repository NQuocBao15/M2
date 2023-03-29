package casetemplate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class CustomerManager {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Customer> customers;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CustomerManager customerManager = new CustomerManager();
        boolean checkActionMenu = true;
        do {
            System.out.println("Menu quản lý customer: ");
            System.out.println("Nhấn 1. Xem danh sách");
            System.out.println("Nhấn 2. Thêm khách hàng ");
            System.out.println("Nhấn 3. Sửa khách hàng");
            System.out.println("Nhấn 4. Xóa khách hàng");
            System.out.println("Nhấn 5. Sắp xếp khách hàng theo tên ");
            System.out.println("Nhấn 6. Sắp xếp khách hàng theo ngày tạo");
            System.out.println("Nhấn 7. Tìm kiếm khách hàng theo tên");
            System.out.println("Nhấn 8. Tìm kiếm khách hàng theo tên hoặc email");
            int actionMenu = Integer.parseInt(scan.nextLine());
            switch (actionMenu) {
                case 1:
                    customerManager.showCustomers();
                    break;
                case 2:
                    customerManager.addCustomer();
                    break;
                case 3:
                    customerManager.editCustomer();
                    break;
                case 4:
                    customerManager.deleteCustomer();
                    break;
                case 5:
                    customerManager.sortCustomersByName();
                    break;
                case 6:

                    break;
                case 7:
                    customerManager.searchByName();
                    break;
                case 8:
                    customerManager.searchByNameOrEmail();
                    break;
                default:
                    System.out.println("Nhập sai rồi bạn ơi! Vui lòng nhập lại");
            }
            boolean checkActionMenuContinue = true;
            do {
                System.out.println("Bạn có muốn tiếp tục hay không: Y/N");
                String actionMenuContinue = scan.nextLine();
                switch (actionMenuContinue) {
                    case "Y":
                        checkActionMenu = true;
                        checkActionMenuContinue = false;
                        break;
                    case "N":
                        checkActionMenu = false;
                        checkActionMenuContinue = false;
                        break;
                    default:
                        checkActionMenuContinue = true;
                }
            }while (checkActionMenuContinue) ;

        } while (checkActionMenu);

    }


    public CustomerManager() {
        customers = new ArrayList<>();

        customers.add(new Customer(1L, "Bao", "quocbao@gmail.com", "28 NTP", new Date()));
        customers.add(new Customer(2L, "Nghia", "nghia@gmail.com", "28 NTP", new Date()));
        customers.add(new Customer(3L, "Quang", "quang@gmail.com", "28 NTP", new Date()));
        customers.add(new Customer(4L, "Toan", "toan@gmail.com", "28 NTP", new Date()));
        customers.add(new Customer(5L, "Luc", "luc@gmail.com", "28 NTP", new Date()));
    }

    public void showCustomers() {
        System.out.printf("%-5s | %-15s | %-25s | %-15s | %-30s \n", "ID", "Name", "Email", "Address", "Date");
        for (int i = 0; i < customers.size(); i++) {
            Customer customer  =  customers.get(i);
            System.out.printf("%-5s | %-15s | %-25s | %-15s | %-30s \n",
                    customer.getId(),customer.getFullName(),customer.getEmail(),
                    customer.getAddress(),customer.getCreateAt());
        }
    }

    public void showCustomers(ArrayList<Customer> customers) {
        System.out.printf("%-5s | %-15s | %-25s | %-15s | %-30s \n", "ID", "Name", "Email", "Address", "Date");
        for (int i = 0; i < customers.size(); i++) {
            Customer customer  =  customers.get(i);
            System.out.printf("%-5s | %-15s | %-25s | %-15s | %-30s \n",
                    customer.getId(),customer.getFullName(),customer.getEmail(),
                    customer.getAddress(),customer.getCreateAt());
        }
    }

    public void addCustomer() {
        System.out.println("Nhap ten khach hang: ");
        String name = scanner.nextLine();
        System.out.println("Nhap email khach hang: ");
        String email = scanner.nextLine();
        System.out.println("Nhap dia chi khach hang: ");
        String address = scanner.nextLine();

        Comparator customerComparator = new ComparatorById();
        customers.sort(customerComparator);
        long maxId = customers.get(customers.size()-1).getId();

        Customer customer = new Customer();
        customer.setId(maxId + 1);
        customer.setFullName(name);
        customer.setEmail(email);
        customer.setAddress(address);
        customer.setCreateAt(new Date());

        customers.add(customer);
        showCustomers();
    }

    public void editCustomer(){
        System.out.println("Nhập ID muốn sửa: ");
        long id = Long.parseLong(scanner.nextLine());

        System.out.println("Nhập tên mới: ");
        String newName = scanner.nextLine();
        System.out.println("Nhập email mới: ");
        String newEmail = scanner.nextLine();
        System.out.println("Nhập địa chỉ mới: ");
        String newAddress = scanner.nextLine();

        for (int i = 0; i < customers.size(); i++) {
            if (id == customers.get(i).getId()) {
                customers.get(i).setFullName(newName);
                customers.get(i).setEmail(newEmail);
                customers.get(i).setAddress(newAddress);
            }
        }
        showCustomers();
    }

    public void deleteCustomer() {
        System.out.println("Nhập ID khách hàng muốn xóa: ");
        long id = Long.parseLong(scanner.nextLine());

        for (int i = 0; i < customers.size(); i++) {
            if (id == customers.get(i).getId()) {
                customers.remove(i);
            }
        }
        showCustomers();
    }

    public void sortCustomersByName() {
        customers.sort(new ComparatorByName());
        showCustomers();
    }

    private void searchByName() {
        System.out.println("Nhập tên muốn tìm kiếm: ");
        String searchName = scanner.nextLine();
        ArrayList<Customer> results = new ArrayList<>();
        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getFullName().contains(searchName)){
                results.add(customers.get(i));
            }
        }
        showCustomers(results);
    }

    private void searchByNameOrEmail() {
        System.out.println("Nhập tên hoặc email muốn tìm kiếm: ");
        String searchName = scanner.nextLine();
        ArrayList<Customer> results = new ArrayList<>();
        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getFullName().contains(searchName) || customers.get(i).getEmail().contains(searchName)){
                results.add(customers.get(i));
            }
        }
        showCustomers(results);
    }
}
/*
     System.out.println("Menu quản lý customer: ");
    System.out.println("Nhấn 1. Xem danh sách");
    System.out.println("Nhấn 2. Thêm khách hàng ");
    System.out.println("Nhấn 3. Sửa khách hàng");
    System.out.println("Nhấn 4. Xóa khách hàng");
    System.out.println("Nhấn 5. Sắp xếp khách hàng theo tên ");
    System.out.println("Nhấn 6. Sắp xếp khách hàng theo ngày tạo");
    System.out.println("Nhấn 7. Tìm kiếm khách hàng theo tên");
    System.out.println("Nhấn 8. Tìm kiếm khách hàng theo tên hoặc email");
     */