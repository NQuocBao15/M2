package service;

import model.Student;
import utils.CSVUtils;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    public final static String PATH = "data/students.csv";
    private static StudentService instance;

    public static StudentService getInstance() {
        if (instance == null) {
            instance = new StudentService();
        }
        return instance;
    }

    public static List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        List<String> records = CSVUtils.readFile(PATH);
        for (String record : records) {
            studentList.add(Student.parseStudent(record));
        }
        return studentList;
    }

    public void addStudent(Student student) {
        List<Student> students = findAll();
        students.add(student);
        CSVUtils.writeFile(PATH, students);
    }

    public void update(Student newStudent) {
        List<Student> studentList = findAll();
        for (Student student : studentList) {
            if (newStudent.getIdStudent().equals(student.getIdStudent())) {
                String name = newStudent.getName();
                if (name != null && !name.isEmpty()) {
                    student.setName(newStudent.getName());
                }
                Integer age = newStudent.getAge();
                if (age != null) {
                    student.setAge(age);
                }
                String gender = newStudent.getGender();
                if (gender != null && gender.isEmpty()) {
                    student.setGender(gender);
                }
                String address = newStudent.getAddress();
                if (address != null && !address.isEmpty()) {
                    student.setAddress(newStudent.getAddress());
                }
                Double averagePoint = newStudent.getAveragePoint();
                if (averagePoint != null) {
                    student.setAveragePoint(averagePoint);
                }
                CSVUtils.writeFile(PATH, studentList);
                break;
            }
        }
    }

    public void remove(Long studentId) {
        List<Student> students = findAll();
        students.removeIf(id -> id.getIdStudent().equals(studentId));
        CSVUtils.writeFile(PATH, students);
    }

    public Student findByID(Long studentId) {
        List<Student> students = findAll();
        for (Student student : students) {
            if (student.getIdStudent().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    public boolean existId(Long studentId) {
        return findByID(studentId) != null;
    }
}
