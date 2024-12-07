package week10.task2_gradeAnalysisSystem;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {

        List<Integer> grades = new ArrayList<>(asList(8,8,6,6,7,10));
        Student student = new Student("Aydin", 2352, grades);
        GradeAnalyzer gradeAnalyzer = new GradeAnalyzer(grades);

        //Access and print the field names and their values for both the GradeAnalyzer and Student classes.
        try{
            Field[] studentFields = student.getClass().getDeclaredFields();
            Field[] gradeFields = gradeAnalyzer.getClass().getDeclaredFields();

            System.out.println("Student class fields: ");
            for(Field f : studentFields){
                f.setAccessible(true);
                System.out.println(f.getName() + ": " + f.get(student));
                f.setAccessible(false);
            }
            System.out.println("\n");

            System.out.println("GradeAnalyzer class fields: ");
            for(Field f : gradeFields){
                f.setAccessible(true);
                System.out.println(f.getName() + ": " + f.get(gradeAnalyzer));
                f.setAccessible(false);
            }
            System.out.println("\n");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        //invoke methods
        try{
            Method[] studentMethods = student.getClass().getDeclaredMethods();
            Method[] gradeMethods = gradeAnalyzer.getClass().getDeclaredMethods();
            List<Method> allMethods = new ArrayList<>();
            allMethods.addAll(asList(studentMethods));
            allMethods.addAll(asList(gradeMethods));

            for(Method m : allMethods){
                m.setAccessible(true);
                Object targetInstance = m.getDeclaringClass().equals(Student.class) ? student : gradeAnalyzer;

                if(m.getName().matches("^calculate.*") || m.getName().matches("^print.*")){
                    if(m.getReturnType().equals(void.class)){
                        m.invoke(targetInstance);
                        System.out.println("The method " + m.getName() + " has been invoked.\n");
                    }
                    else{
                        System.out.println(m.invoke(targetInstance) + "\n");
                    }
                }
            }
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }
}
