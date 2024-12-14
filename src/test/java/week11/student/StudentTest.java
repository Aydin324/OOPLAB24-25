package week11.student;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import week11.exceptions.EmptyStudentListException;
import week11.exceptions.StudentNotFoundException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {

    private static Student student;

    @BeforeAll
    public static void setup(){
        student = new Student(99, "Aydin Sulejmanovic", "IBU", "IT", 8.5);
    }

    @Test
    public void testDoesNotThrow_PrintStudent(){
        assertDoesNotThrow(() -> {
            System.out.println(student);
        });
    }

    @Test
    public void testStudentName(){
        assertEquals("Aydin Sulejmanovic", student.getName());
    }

    @Test
    public void testStudentUniversity(){
        assertEquals("IBU", student.getUniversity());
    }

    @Test
    public void testStudentDepartment(){
        assertEquals("IT", student.getDepartment());
    }

}
