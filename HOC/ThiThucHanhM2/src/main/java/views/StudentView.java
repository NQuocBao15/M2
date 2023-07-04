package views;

import model.Student;
import service.SortByGPA;
import service.StudentService;
import utils.AppUtils;

import java.util.List;
import java.util.Scanner;

public class StudentView {
    public static List<Student> students;
    private static StudentService studentService = new StudentService();
    private static final Scanner input = new Scanner(System.in);

    public static void addStudent() {
        boolean flag = true;
        do {
            System.out.println("Thêm sinh viên");
            Long studentId = System.currentTimeMillis()/1000;
            String name = inputName(Status.ADD);
            Integer age = inputAge(Status.ADD);
            String gender = inputGender(Status.ADD);
            String address = inputAddress(Status.ADD);
            Double averagePoint = inputAveragePoint(Status.ADD);
            Student student = new Student(studentId,name,age,gender,address,averagePoint);
            studentService.addStudent(student);
            System.out.println("Thêm thành công");
            showStudentsListUp();
            Menu.view();
        } while (!flag);
    }

    public static void sortAveragePoint() {
        List<Student> students1 = studentService.findAll();
        SortByGPA sortByGPA = new SortByGPA();
        students1.sort(sortByGPA);
        showSortList(students1);
    }

    public static void sortAveragePointView() {
        try {
            boolean flag = true;
            String choice;
            System.out.println("Sắp Xếp Theo Điểm Trung Bình");
            System.out.println("1.Điểm tăng dần");
            System.out.println("2.Điểm giảm dần");
            System.out.println("0.Quay lại Menu chính");
            System.out.println("Chọn chức năng: ");
            System.out.print("==> ");
            do {
                choice = input.nextLine();
                switch (choice) {
                    case "1":
                        sortAveragePoint();
                        break;
                    case "2":
//                        sortAveragePointDown();
                        break;
                    case "0":
                        Menu.view();
                    default:
                        System.out.println("Lựa chọn không hợp lệ");
                        System.out.print("==> ");
                        flag = false;
                }
            } while (!flag);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private static void showSortList(List<Student> students1) {

        System.out.println("Danh Sách Sinh Viên");
        System.out.printf("%-18s %-25s %-10s %-15s %-20s %-12s\n", "Mã SV", "Tên Sinh Viên", "Tuổi", "Giới tính", "Địa chỉ", "ĐTB");

        for (Student student : students1) {
            System.out.printf("%-18s %-25s %-10s %-15s %-20s %-12s\n",
                    student.getIdStudent(),
                    student.getName(),
                    student.getAge(),
                    student.getGender(),
                    student.getAddress(),
                    student.getAveragePoint());
        }
        int choice;
        do {
            System.out.println("Nhấn 0 để quay lại SortMenu");
            System.out.print("==> ");
            choice = AppUtils.retryParseInt();
        } while (choice != 0);
    }

    public static void showStudentsList() {
        System.out.println("Danh sách sinh viên");
        System.out.printf("%-18s %-25s %-10s %-15s %-20s %-12s\n", "Mã SV", "Tên Sinh Viên", "Tuổi", "Giới tính", "Địa chỉ", "ĐTB");
        for (Student student : studentService.findAll()) {
            System.out.printf("%-18s %-25s %-10s %-15s %-20s %-12s\n",
                    student.getIdStudent(),
                    student.getName(),
                    student.getAge(),
                    student.getGender(),
                    student.getAddress(),
                    student.getAveragePoint());
        }
    }

    public static void showStudentsListUp() {
        showStudentsList();
        int choice;
        do {
            System.out.println("Nhập 0 để quay lại");
            System.out.println("==>");
            choice = AppUtils.retryParseInt();
        } while (choice != 0);
    }

    public static void removeStudent() {
        try {
            boolean flag = true;
            showStudentsList();
            Long id = inputIDStudent(Status.REMOVE);
            System.out.println("Xóa sinh viên");
            System.out.println("Nhập Y để xóa sinh viên");
            System.out.println("Nhập ký tự bất kì để quay lại Menu");
            System.out.println();
            System.out.println("Chọn chức năng");
            System.out.println("==> ");
            do {
                String choice = input.nextLine();
                switch (choice) {
                    case "Y":
                        studentService.remove(id);
                        System.out.println("Sản phẩm đã được xóa");
                        showStudentsListUp();
                        Menu.view();
                        break;
                    default:
                        Menu.view();
                        break;
                }
            } while (!flag);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static Long inputIDStudent(Status status) {
        Long studentId;
        switch (status) {
            case EDIT:
            case REMOVE:
                System.out.println("Nhập ID sản phẩm cần xóa");
        }
        System.out.println("==> ");
        boolean flag = true;
        do {
            studentId = AppUtils.retryParseLong();
            boolean exist = studentService.existId(studentId);
            switch (status) {
                case EDIT:
                case REMOVE:
                    if (!exist) {
                        System.out.println("Không tìm thấy ID, vui lòng nhập lại");
                        System.out.println("==> ");
                    }
                    flag = !exist;
                    break;
            }
        } while (flag);
        return studentId;
    }

    private static double inputAveragePoint(Status status) {
        double averagePoint;
        switch (status) {
            case ADD:
                System.out.println("Nhập điểm trung bình của sinh viên: ");
                break;
            case EDIT:
                System.out.println("Nhập điểm trung bình muốn sửa: ");
                break;
        }
        System.out.print("==> ");
        boolean flag = true;
        do {
            averagePoint = AppUtils.retryParseDouble();
            boolean exist = (averagePoint > 0);
            switch (status) {
                case ADD:
                case EDIT:
                case REMOVE:
                    if (!exist) {
                        System.out.println("Bạn nhập sai định dạng (Số lượng phải lớn hơn 1 )");
                        System.out.print("==> ");
                    }
                    flag = !exist;
                    break;
            }
        } while (flag);
        return averagePoint;
    }

    private static String inputAddress(Status status) {
        String address;
        switch (status) {
            case ADD:
                System.out.println("Nhập địa chỉ sinh viên: ");
                break;
            case EDIT:
                System.out.println("Nhập địa chỉ sinh viên muốn sửa: ");
                break;
        }
        System.out.print("==> ");
        boolean flag = true;
        do {
            address = input.nextLine().trim();
            boolean exist = (!address.isEmpty());
            switch (status) {
                case ADD:
                case EDIT:
                    if (!exist) {
                        System.out.println("Bạn nhập sai định dạng, vui lòng nhập lại: ");
                        System.out.print("==> ");
                    }
                    flag = !exist;
                    break;
            }
        } while (flag);
        return address;
    }

    private static String inputGender(Status status) {
        String gender;
        switch (status) {
            case ADD:
                System.out.println("Nhập giới tính sinh viên: ");
                break;
            case EDIT:
                System.out.println("Nhập giới tính sinh viên muốn sửa: ");
                break;
        }
        System.out.print("==> ");
        boolean flag = true;
        do {
            gender = input.nextLine().trim();
            boolean exist = (!gender.isEmpty());
            switch (status) {
                case ADD:
                case EDIT:
                    if (!exist) {
                        System.out.println("Bạn nhập sai định dạng, vui lòng nhập lại: ");
                        System.out.print("==> ");
                    }
                    flag = !exist;
                    break;
            }
        } while (flag);
        return gender;
    }

    private static int inputAge(Status status) {
        int age;
        switch (status) {
            case ADD:
                System.out.println("Nhập tuổi của sinh viên: ");
                break;
            case EDIT:
                System.out.println("Nhập tuổi của sinh viên muốn sửa: ");
                break;
        }
        System.out.print("==> ");
        boolean flag = true;
        do {
            age = AppUtils.retryParseInt();
            boolean exist = (age > 0);
            switch (status) {
                case ADD:
                case EDIT:
                case REMOVE:
                    if (!exist) {
                        System.out.println("Bạn nhập sai định dạng (Số lượng phải lớn hơn 1 )");
                        System.out.print("==> ");
                    }
                    flag = !exist;
                    break;
            }
        } while (flag);
        return age;
    }

    public static String inputName(Status status) {
        String name;
        switch (status) {
            case ADD:
                System.out.println("Nhập tên sinh viên: ");
                break;
            case EDIT:
                System.out.println("Nhập tên sinh viên mới: ");
                break;
        }
        System.out.print("==> ");
        boolean flag = true;
        do {
            name = input.nextLine().trim();
            boolean exist = (!name.isEmpty());
            switch (status) {
                case ADD:
                case EDIT:
                    if (!exist) {
                        System.out.println("Bạn nhập sai định dạng, vui lòng nhập lại: ");
                        System.out.print("==> ");
                    }
                    flag = !exist;
                    break;
            }
        } while (flag);
        return name;
    }

    public static void editStudent() {
        try {
            showStudentsList();
            System.out.println("Nhập mã sinh viên muốn sửa: ");
            System.out.print("==> ");
            Long id = AppUtils.retryParseLong();
            if (studentService.existId(id)) {
                boolean flag = true;
                System.out.println();
                System.out.println("Chỉnh Sửa Thông Tin Sinh Viên");
                System.out.println("1.Sửa tên sinh viên ");
                System.out.println("2.Sửa tuổi sinh viên");
                System.out.println("3.Sửa giới tính");
                System.out.println("4.Sửa địa chỉ sinh viên");
                System.out.println("5. Sửa điểm trung bình sinh viên");
                System.out.println("0.Quay lại quản lý sản phẩm");
                System.out.println("Chọn chức năng: ");
                System.out.print("==> ");
                Student newStudent = new Student();
                newStudent.setIdStudent(id);
                do {
                    String choice = input.nextLine();
                    switch (choice) {
                        case "1":
                            editName(newStudent);
                            break;
                        case "2":
                            editAge(newStudent);
                            break;
                        case "3":
                            editGender(newStudent);
                            break;
                        case "4":
                            editAddress(newStudent);
                            break;
                        case "5":
                            editAveragePoint(newStudent);
                            break;
                        case "0":
                            Menu.view();
                            break;
                        default:
                            System.out.println("Nhập sai vui lòng nhập lại: ");
                            System.out.print("==> ");
                            flag = false;
                    }
                } while (!flag);
            } else {
                System.out.println("Không tìm thấy mã sinh viên");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void editName(Student newStudent) {
        String name = inputName(Status.EDIT);
        newStudent.setName(name);
        studentService.update(newStudent);
        System.out.println("Tên ssinh viên đã được cập nhập");
        showStudentsList();
    }

    public static void editAge(Student newStudent) {
        int age =  inputAge(Status.EDIT);
        newStudent.setAge(age);
        studentService.update(newStudent);
        System.out.println("Tuổi sinh viên đã được cập nhập");
        showStudentsList();
    }

    public static void editGender(Student newStudent) {
        String gender = inputGender(Status.EDIT);
        newStudent.setGender(gender);
        studentService.update(newStudent);
        System.out.println("Giới tính sinh viên đã được cập nhập");
        showStudentsList();
    }

    public static void editAddress(Student newStudent) {
        String address = inputAddress(Status.EDIT);
        newStudent.setAddress(address);
        studentService.update(newStudent);
        System.out.println("Địa chỉ sinh viên đã được cập nhập");
        showStudentsList();
    }

    public static void editAveragePoint(Student newStudent) {
        double averagePoint =  inputAveragePoint(Status.EDIT);
        newStudent.setAveragePoint(averagePoint);
        studentService.update(newStudent);
        System.out.println("Điểm trung bình của sinh viên đã được cập nhập");
        showStudentsList();
    }
}
