package com.spring.hibernate_demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/** Represents a student stored in the student table. */
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    /** Creates an empty student for JPA. */
    public Student() {
    }

    /**
     * Creates a student with the supplied contact details.
     *
     * @param firstName student's first name
     * @param lastName student's last name
     * @param email student's email address
     */
    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /**
     * Gets the student's identifier.
     *
     * @return student's identifier
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the student's identifier.
     *
     * @param id student's identifier
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the student's first name.
     *
     * @return student's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the student's first name.
     *
     * @param firstName student's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the student's last name.
     *
     * @return student's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the student's last name.
     *
     * @param lastName student's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the student's email address.
     *
     * @return student's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the student's email address.
     *
     * @param email student's email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns a string representation of this student.
     *
     * @return string representation of this student
     */
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}