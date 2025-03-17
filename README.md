# Student Management System

## Description
This Java program is a simple Student Management System that allows users to add students, mark their attendance, view student details, and save/load data from a file. The data is stored in a serialized file to maintain persistence between program runs.

## Features
- Insert new student details (Name, Age, Year, Student Number).
- Display all students.
- Mark attendance for students.
- View attendance records.
- Save student data to a file.
- Load student data from a file upon program startup.

## Prerequisites
- Java Development Kit (JDK) 8 or later

## How to Run
1. Compile the program using:
   ```sh
   javac MainStudent.java
   ```
2. Run the program using:
   ```sh
   java MainStudent
   ```

## Program Usage
Upon running the program, you will be presented with a menu:
```
Select your choice....
INSERT STUDENT ENTER               1
GET ALL STUDENT ENTER              2
SET ALL STUDENT ATTENDANCE ENTER   3
GET ALL STUDENT ATTENDANCE ENTER   4
SAVE DATA ENTER                    5
EXIT 0
```

### Options
- **1**: Add a new student by entering their details.
- **2**: Display all students with their information.
- **3**: Mark attendance for all students.
- **4**: View attendance records.
- **5**: Save the student list to a file.
- **0**: Exit the program.

## File Storage
- The student data is stored in a file named `database/myDb.txt` using Java serialization.
- Data is automatically loaded from the file when the program starts.

## Good Programming Practices Demonstrated
### Modularity
- The program is structured using methods that handle distinct tasks, such as `insertStudent()`, `showStudent()`, `makePresentsForAllStudent()`, and `exportToFile()`. This ensures separation of concerns and makes the code easier to maintain and modify.

### Functionality
- Implements all basic CRUD (Create, Read, Update, Delete) operations for student management.
- Uses file I/O for data persistence, ensuring that student records are saved and retrieved correctly.
- Includes an interactive menu-driven system for ease of use.

### Readability
- Uses meaningful variable and method names that clearly describe their purpose.
- Proper indentation and spacing make the code easy to follow.
- Comments are provided to clarify complex logic where necessary.

### Error Handling
- The program includes try-catch blocks to handle potential exceptions, such as file I/O errors or invalid user input, preventing crashes.

### Object-Oriented Design
- The `Student` class encapsulates student details and behaviors, ensuring data integrity through getter and setter methods.
- Uses serialization to store and retrieve objects efficiently.

### Code Reusability
- The program follows the DRY (Don't Repeat Yourself) principle by reusing the `BufferedReader` for input handling and abstracting repeated logic into methods.

## Notes
- The `clearScreen()` method attempts to clear the console but may not work in all environments.
- Ensure that the `database/` directory exists before running the program.

## Author
- Developed by [Your Name]

