package week11.student;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import week11.exceptions.EmptyStudentListException;
import week11.exceptions.StudentNotFoundException;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentSystemTest {

    private static StudentSystem studentSystem;

    @BeforeAll
    public static void setUp(){
        studentSystem = new StudentSystem("src/main/resources/students.csv");
    }

    @Test
    public void testIfStudentIsPresent(){
        assertTrue(studentSystem.noOfStudents()>0, "There should be at least one student.");
    }

    @Test
    public void testStudentWithId100(){
        assertFalse(studentSystem.getStudentByID(100).isPresent(), "There should be no student with id 100.");
    }

    @Test
    public void testHighestGPAStudent() throws StudentNotFoundException {
        assertEquals(9.8, studentSystem.getHighestGPAStudent().getGPA());
    }

    @Test
    public void testExceptionForEmptyStudentList(){
        assertThrowsExactly(EmptyStudentListException.class, () -> {
            StudentSystem emptyStudentSystem = new StudentSystem("src/main/resources/empty_students.csv");
            emptyStudentSystem.getHighestGPAStudent();
        }, "Exception should be thrown for empty student list.");
    }

    @Test
    public void testExceptionMessageForEmptyStudentList(){
        Exception exception = assertThrows(Exception.class, () -> {
            StudentSystem emptyStudentSystem = new StudentSystem(new ArrayList<Student>());
        });
        assertEquals("List of students is empty.", exception.getMessage(),
                "Exception message should be: 'List of students is empty.'");
    }

    @Test
    public void testNamesArrray(){
        String[] expected = new String[5];
        for(int i=0; i<5; i++){
            expected[i] = studentSystem.getStudents().get(i).getName();
        }
        assertArrayEquals(new String[]{"Camila Wood", "Alexander Thompson", "Liam Taylor", "Evelyn Jenkins", "Michael Jackson"},
                expected, "Names of students don't match.");
    }

    @Test
    public void testSameStudent() throws StudentNotFoundException {
        assertTrue(studentSystem.getStudentByID(12).isPresent(), "Student with ID 12 should be present.");
        assertEquals(studentSystem.getHighestGPAStudent(), studentSystem.getStudentByID(12).get(),
                "Students don't match.");
    }

    @Test
    public void testGetLongestNameStudentDoesNotThrowsException(){
        assertDoesNotThrow(() -> {
            studentSystem.getLongestNameStudent();
        });
    }

}