package week4.task3and4;

import java.util.ArrayList;

public class Student extends Person {
    private int credits=0;
    private String student_id;
    private ArrayList<Integer> grades = new ArrayList<>();

    public Student(String name, String address, int age, String country, String student_id){
        super(name, address, age, country);
        this.student_id = student_id;
    }

    public int credits() {
        return credits;
    }

    public void study(){
        credits++;
    }

    @Override
    public String toString(){
        return getName() + "\n\t" + getAddress() + "\n\tage "+ getAge() + "\n\tcountry "+ getCountry() + "\n\tcredits " + credits;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public void addGrade(int grade){
        if(grade>4 && grade<11){
            grades.add(grade);
        }
    }

    public void printGrades(){
        System.out.print("Grades: ");
        for(int i : grades){
            System.out.print(i + " ");
        }
    }

}
