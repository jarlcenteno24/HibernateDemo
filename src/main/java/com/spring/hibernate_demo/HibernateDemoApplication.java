package com.spring.hibernate_demo;

import com.spring.hibernate_demo.dao.StudentDao;
import com.spring.hibernate_demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

/** Starts the Spring Boot application and provides sample student operations. */
@SpringBootApplication
public class HibernateDemoApplication {

    /**
     * Starts the application.
     *
     * @param args command-line arguments passed to the application
     */
    public static void main(String[] args) {
        SpringApplication.run(HibernateDemoApplication.class, args);
    }

    /**
     * Creates the command-line runner for the sample student operations.
     *
     * @param studentDao data access object used by the operations
     * @return a runner that executes the selected sample operation
     */
    @Bean
    public CommandLineRunner commandLineRunner(StudentDao studentDao) {
        return runner -> {
            // Uncomment the methods you wish to execute:

            createStudent(studentDao);
            // readStudent(studentDao);
            // queryStudent(studentDao);
            // updateStudent(studentDao);
            // deleteStudent(studentDao);
            // deleteAllStudents(studentDao);
        };
    }

    /** Creates and persists a sample student. */
    private void createStudent(StudentDao studentDao) {
        System.out.println("Creating new student object...");
        Student tempStudent = new Student("Light", "Yagami", "light.yagami@example.com");

        System.out.println("Saving the student...");
        studentDao.save(tempStudent);

        System.out.println("Saved student. Generated ID: " + tempStudent.getId());
    }

    /** Retrieves and prints the student with the sample ID. */
    private void readStudent(StudentDao studentDao) {
        int id = 1;
        System.out.println("Retrieving student with ID: " + id);
        Student myStudent = studentDao.findById(id);
        System.out.println("Found student: " + myStudent);
    }

    /** Retrieves and prints all students and those matching a sample last name. */
    private void queryStudent(StudentDao studentDao) {
        System.out.println("Getting all students...");
        List<Student> students = studentDao.findAll();
        for (Student tempStudent : students) {
            System.out.println(tempStudent);
        }

        System.out.println("\nGetting students by last name 'Yagami'...");
        List<Student> yagamiStudents = studentDao.findByLastName("Yagami");
        for (Student tempStudent : yagamiStudents) {
            System.out.println(tempStudent);
        }
    }

    /** Changes the first name of the sample student and persists the update. */
    private void updateStudent(StudentDao studentDao) {
        int studentId = 1;
        System.out.println("Getting student with ID: " + studentId);
        Student myStudent = studentDao.findById(studentId);

        if (myStudent != null) {
            System.out.println("Updating student's first name to 'Dark'...");
            myStudent.setFirstName("Dark");
            studentDao.update(myStudent);
            System.out.println("Updated student: " + myStudent);
        }
    }

    /** Deletes the student with the sample ID. */
    private void deleteStudent(StudentDao studentDao) {
        int studentId = 22;
        System.out.println("Deleting student with ID: " + studentId);
        studentDao.delete(studentId);
        System.out.println("Deleted student ID: " + studentId);
    }

    /** Deletes all students and prints the number of deleted rows. */
    private void deleteAllStudents(StudentDao studentDao) {
        System.out.println("Deleting all students from database...");
        int numRowsDeleted = studentDao.deleteAll();
        System.out.println("Deleted row count: " + numRowsDeleted);
    }
}