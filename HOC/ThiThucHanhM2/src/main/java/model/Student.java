package model;

import java.util.List;
import java.util.Objects;

public class Student {
    private Long idStudent;
    private String name;
    private Integer age;
    private String gender;
    private String address;
    private Double averagePoint;
    public List<Student> students;

    public Student() {

    }

    public Student(Long idStudent, String name, Integer age, String gender, String address, Double averagePoint, List<Student> students) {
        this.idStudent = idStudent;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.averagePoint = averagePoint;
        this.students = students;
    }

    public Student(Long idStudent, String name, Integer age, String gender, String address, Double averagePoint) {
        this.idStudent = idStudent;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.averagePoint = averagePoint;
    }

    public Long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Long idStudent) {
        this.idStudent = idStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getAveragePoint() {
        return averagePoint;
    }

    public void setAveragePoint(Double averagePoint) {
        this.averagePoint = averagePoint;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public static Student parseStudent(String rawStudent) {
        String[] array = rawStudent.split(",");
        Student student = new Student();
        student.setIdStudent(Long.parseLong(array[0]));
        student.setName(array[1]);
        student.setAge(Integer.parseInt(array[2]));
        student.setGender(array[3]);
        student.setAddress(array[4]);
        student.setAveragePoint(Double.parseDouble(array[5]));
        return student;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStudent, name, age, gender, address, averagePoint, students);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return     Objects.equals(idStudent, student.idStudent)
                && Objects.equals(name, student.name)
                && Objects.equals(age, student.age)
                && Objects.equals(gender, student.gender)
                && Objects.equals(address, student.address)
                && Objects.equals(averagePoint, student.averagePoint)
                && Objects.equals(students, student.students);
    }


    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s",
                idStudent,
                name,
                age,
                gender,
                address,
                averagePoint);
    }
}
