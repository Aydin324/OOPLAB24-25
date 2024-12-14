package week11.student;

import week11.exceptions.EmptyStudentListException;
import week11.exceptions.InvalidStudentDataException;
import week11.exceptions.StudentNotFoundException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class StudentSystem {
    private List<Student> students;

    //constructors
    public StudentSystem(String filename) {
        List<Student> tempStudents = new ArrayList<>(readStudents(filename));
        try {
            validateStudentData(tempStudents);
            students = tempStudents;
        } catch (InvalidStudentDataException e) {
            throw new RuntimeException(e);
        }
    }

    public StudentSystem(List<Student> students){
        if(students.isEmpty()) throw new EmptyStudentListException("List of students is empty.");
        this.students = students;
    }

    //Read file and return a list
    public static List<Student> readStudents(String filename) {
        List<String> studentList = new ArrayList<>();
        List<Student> readStudents = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader(filename))) {
            studentList = bf.lines().toList();
            if(studentList.isEmpty()) throw new EmptyStudentListException("File is empty!");
            for(String s : studentList) {
                String[] split = s.split(",");
                readStudents.add(new Student(parseInt(split[0]), split[1], split[2], split[3], parseDouble(split[4])));
            }
            return readStudents;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int noOfStudents() {
        return students.size();
    }

    public Optional<Student> getStudentByID(int id){
        return students.stream().filter(s -> s.getID() == id).findFirst();
    }

    public Student getHighestGPAStudent() throws StudentNotFoundException {
        Optional<Student> highestGPAStudent = students.stream()
                .max(Comparator.comparingDouble(Student::getGPA));
        if(highestGPAStudent.isPresent()) return highestGPAStudent.get();
        throw new StudentNotFoundException("There is no such result!");
    }

    public Student getLongestNameStudent() throws StudentNotFoundException {
        return students.stream()
                    .max(Comparator.comparingInt(s -> s.getName().length()))
                    .orElseThrow(() -> new StudentNotFoundException("There is no such result!"));
    }

    //private validation method
    private void validateStudentData(List<Student> readStudents) throws InvalidStudentDataException {
        for(Student s : readStudents){
            if(s.getGPA()<6 || s.getGPA()>10){
                throw new InvalidStudentDataException(s.getName() + " has an invalid GPA!");
            }
        }
    }

    //getter
    public List<Student> getStudents() {
        return students;
    }
}
