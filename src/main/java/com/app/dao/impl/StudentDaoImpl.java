package com.app.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.dao.IStudentDao;
import com.app.model.student.Student;
import com.app.util.HibernateUtil;



public class StudentDaoImpl implements IStudentDao {
    public int saveStudent(Student s) {
        Transaction tx = null;
        int id = 0;
        try (Session ses = HibernateUtil.getSessionFactory().openSession()) {
            tx = ses.beginTransaction();
            Object pk = ses.save(s);
            id = (int) pk;
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return id;
    }

    public List<Student> getAllStud() {
        try (Session ses = HibernateUtil.getSessionFactory().openSession()) {
            return ses.createQuery("from Student", Student.class).list();
        }
    }
}