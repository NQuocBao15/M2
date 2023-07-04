package service;

import model.Student;

import java.util.Comparator;

public class SortByGPA implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return (int) (o1.getAveragePoint() - o2.getAveragePoint());
    }
}
