package week10.task2_gradeAnalysisSystem;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int ID;
    private List<Integer> grades = new ArrayList<>();

    public Student(String name, int ID, List<Integer> grades) {
        this.name = name;
        this.ID = ID;
        this.grades = grades;
    }

    public void printInfo() {
        System.out.println("Student Info:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + ID);
        System.out.println("Grades: " + grades);
    }

}
