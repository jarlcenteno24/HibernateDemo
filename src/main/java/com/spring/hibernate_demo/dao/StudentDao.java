package com.spring.hibernate_demo.dao;

import com.spring.hibernate_demo.entity.Student;
import java.util.List;

/** Defines persistence operations for {@link Student} entities. */
public interface StudentDao {

    /**
     * Persists a new student.
     *
     * @param student student to persist
     */
    void save(Student student);

    /**
     * Finds a student by its identifier.
     *
     * @param id identifier of the student
     * @return the matching student, or {@code null} if none exists
     */
    Student findById(Integer id);

    /**
     * Retrieves all students.
     *
     * @return all persisted students
     */
    List<Student> findAll();

    /**
     * Finds students with the specified last name.
     *
     * @param lastName last name to match
     * @return students whose last name matches
     */
    List<Student> findByLastName(String lastName);

    /**
     * Updates a persisted student.
     *
     * @param student student containing the updated values
     */
    void update(Student student);

    /**
     * Deletes a student by its identifier.
     *
     * @param id identifier of the student to delete
     */
    void delete(Integer id);

    /**
     * Deletes every student.
     *
     * @return number of deleted rows
     */
    int deleteAll();
}