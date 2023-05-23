import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MainStudentTest {

    private ByteArrayOutputStream outputStream;
    private PrintStream originalOutput;

    @BeforeEach
    public void setUp() {
        // Redirect System.out to capture output
        outputStream = new ByteArrayOutputStream();
        originalOutput = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testInsertStudent() throws IOException {
        // Arrange
        ByteArrayInputStream input = new ByteArrayInputStream("John\n20\n3\n12345\n".getBytes());
        System.setIn(input);
        MainStudent.studentsList = new ArrayList<>();

        // Act
        MainStudent.insertStudent();

        // Assert
        List<MainStudent.Student> studentsList = MainStudent.studentsList;
        assertEquals(1, studentsList.size());
        MainStudent.Student student = studentsList.get(0);
        assertEquals("John", student.getName());
        assertEquals(20, student.getAge());
        assertEquals(3, student.getYear());
        assertEquals("12345", student.getstudentNum());
    }

    @Test
    public void testShowStudent() {
        // Arrange
        MainStudent.studentsList = new ArrayList<>();
        MainStudent.studentsList.add(new MainStudent.Student("John", 20, 3, "12345"));
        MainStudent.studentsList.add(new MainStudent.Student("Jane", 22, 4, "54321"));

        // Act
        MainStudent.showStudent();

        // Assert
        String expectedOutput = "\n........................Students........................\n" +
                "Student : 1\n" +
                "Name: John - Age: 20 - Year: 3 - Student Number: 12345\n" +
                "...........................................................................\n" +
                "Student : 2\n" +
                "Name: Jane - Age: 22 - Year: 4 - Student Number: 54321\n" +
                "...........................................................................\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testMakePresentsForAllStudent() throws IOException {
        // Arrange
        ByteArrayInputStream input = new ByteArrayInputStream("p\nn\n".getBytes());
        System.setIn(input);
        MainStudent.studentsList = new ArrayList<>();
        MainStudent.studentsList.add(new MainStudent.Student("John", 20, 3, "12345"));
        MainStudent.studentsList.add(new MainStudent.Student("Jane", 22, 4, "54321"));

        // Act
        MainStudent.makePresentsForAllStudent();

        // Assert
        List<MainStudent.Student> studentsList = MainStudent.studentsList;
        assertTrue(studentsList.get(0).isPresent());
        assertTrue(!studentsList.get(1).isPresent());
    }

    @Test
    public void testShowAttendance() throws IOException {
        // Arrange
        ByteArrayInputStream input = new ByteArrayInputStream("p\nn\n".getBytes());
        System.setIn(input);
        MainStudent.studentsList = new ArrayList<>();
        MainStudent.studentsList.add(new MainStudent.Student("John", 20, 3, "12345"));
        MainStudent.studentsList.add(new MainStudent.Student("Jane", 22, 4, "54321"));

        // Act
        MainStudent.showAttendance();

        // Assert
        String expectedOutput = "\n........................Students........................\n" +
                "Name: John - Age: 20 - Year: 3 - Student Number: 12345\n" +
                "Is Presented then ENTER 'p' else ENTER 'n'=>\n" +
                "John Present today...\n" +
                "...........................................................................\n" +
                "Name: Jane - Age: 22 - Year: 4 - Student Number: 54321\n" +
                "Is Presented then ENTER 'p' else ENTER 'n'=>\n" +
                "Jane Absent today...\n" +
                "...........................................................................\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testExportAndImportFromFile() throws IOException {
        // Arrange
        MainStudent.studentsList = new ArrayList<>();
        MainStudent.studentsList.add(new MainStudent.Student("John", 20, 3, "12345"));
        MainStudent.studentsList.add(new MainStudent.Student("Jane", 22, 4, "54321"));
        MainStudent.exportToFile();

        // Clear studentsList
        MainStudent.studentsList = null;

        // Act
        MainStudent.importFromFile();

        // Assert
        List<MainStudent.Student> studentsList = MainStudent.studentsList;
        assertEquals(2, studentsList.size());
        assertEquals("John", studentsList.get(0).getName());
        assertEquals("Jane", studentsList.get(1).getName());
    }
}
