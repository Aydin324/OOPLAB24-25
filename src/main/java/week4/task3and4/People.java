package week4.task3and4;

import java.util.List;

public class People {
    public static void main(String[] args) {
        Person p = new Person("Aydin", "Porodice Ribar", 20, "Bosnia and Herzegovina");
        System.out.println(p);

        Student s = new Student("Adi", "sdsd", 23, "Bosnia", "521452");
        s.addGrade(5);
        s.addGrade(6);
        System.out.println(s);
        s.printGrades();


    }

    public static void printDepartment(List<Person> people) {
        for (Person person : people) {
            System.out.println(person);
        }
    }
}
