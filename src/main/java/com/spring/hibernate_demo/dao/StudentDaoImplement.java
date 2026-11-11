package com.spring.hibernate_demo.dao;

import com.spring.hibernate_demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/** Implements student persistence operations with JPA. */
@Repository
public class StudentDaoImplement implements StudentDao {

    private final EntityManager entityManager;

    /**
     * Creates the DAO using the supplied entity manager.
     *
     * @param entityManager entity manager used for persistence operations
     */
    @Autowired
    public StudentDaoImplement(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Create
    /** {@inheritDoc} */
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    // Read
    /** {@inheritDoc} */
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    // Query - Find All (Ordered by lastName ASC)
    /** {@inheritDoc} */
    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery(
                "FROM Student ORDER BY lastName ASC", Student.class);
        return query.getResultList();
    }

    // Query - Find By Last Name (Parameterized using Named Parameter to prevent SQL Injection)
    /** {@inheritDoc} */
    @Override
    public List<Student> findByLastName(String lastname) {
        TypedQuery<Student> query = entityManager.createQuery(
                "FROM Student WHERE lastName = :data", Student.class);
        query.setParameter("data", lastname);
        return query.getResultList();
    }

    // Update
    /** {@inheritDoc} */
    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    // Delete Single Record
    /** {@inheritDoc} */
    @Override
    @Transactional
    public void delete(Integer id) {
        Student student = entityManager.find(Student.class, id);
        if (student != null) {
            entityManager.remove(student);
        }
    }

    // Delete All Records
    /** {@inheritDoc} */
    @Override
    @Transactional
    public int deleteAll() {
        return entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }
}