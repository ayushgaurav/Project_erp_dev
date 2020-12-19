package com.example.projecterp.dao.impl;

import com.example.projecterp.bean.Students;
import com.example.projecterp.dao.StudentsDAO;
import com.example.projecterp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class StudentsDAOImpl implements StudentsDAO {
    Students new_student = new Students();
    Query<Students> query;
    List<Students> students;

    @Override
    public void addStudent(Students student) {
        System.out.println(student.getEmail());
        new_student = student;

        try(Session session = SessionUtil.getSession()){
            session.beginTransaction();
            //Generate roll number
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Object> criteriaQuery = cb.createQuery(Object.class);
            Root<Students> root = criteriaQuery.from(Students.class);
            criteriaQuery.select(cb.max(root.get("student_id")));

            Query query = session.createQuery(criteriaQuery);
            Object max_id = query.getSingleResult();
            String new_roll_number = "CSE_" + String.valueOf(Integer.parseInt(max_id.toString()) + 1);

            System.out.println("New ID: " + new_roll_number);

            //Generate roll number
//            Query query = session.createQuery("select max(s.student_id) from Students s",Students.class);
//            List list = query.list();
//            System.out.println("Result: " + list.get(0));
            new_student.setRoll_number(new_roll_number);

            //Add student
            Integer id = (Integer) session.save(student);
            System.out.println("Student created with id:" + id);
            session.getTransaction().commit();
        }catch (HibernateException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Students> viewAllStudents(){
        try(Session session = SessionUtil.getSession()){
            session.beginTransaction();
            query = session.createQuery("select s from Students s", Students.class);
            students = query.getResultList();

            for (Students s : students) {
                System.out.println(s.getEmail());
            }

            System.out.println(students.toArray().toString());
            session.getTransaction().commit();
        }catch (HibernateException e){
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public Students viewStudent(String roll_number) {
        try(Session session = SessionUtil.getSession()){
            session.beginTransaction();
            System.out.println("DAO IMPL roll_number: " + roll_number);
            query = session.createQuery("select s from Students s where s.roll_number = :rn",Students.class);
            new_student = query.setParameter("rn", roll_number).getSingleResult();
            System.out.println(new_student.getEmail());
            session.getTransaction().commit();
        }catch (HibernateException e){
            e.printStackTrace();
        }
        return new_student;
    }

    @Override
    public void updateStudent(Students student) {
        String roll_number = student.getRoll_number();
        try(Session session = SessionUtil.getSession()){
            session.beginTransaction();
            System.out.println("DAO IMPL roll_number: " + roll_number);
            Query<Students> query = session.createQuery("select s from Students s where s.roll_number = :rn",Students.class);
            new_student = query.setParameter("rn", roll_number).getSingleResult();
            new_student.setFirst_name(student.getFirst_name());
            new_student.setLast_name(student.getLast_name());
            new_student.setEmail(student.getEmail());
            new_student.setGraduation_year(student.getGraduation_year());
            new_student.setTotal_credit(student.getTotal_credit());
            session.update(new_student);
            System.out.println("Updated!");
            session.getTransaction().commit();
        }catch (HibernateException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(String roll_number) {
        try(Session session = SessionUtil.getSession()){
            session.beginTransaction();
            System.out.println("DAO IMPL roll_number: " + roll_number);
            Query<Students> query = session.createQuery("select s from Students s where s.roll_number = :rn",Students.class);
            Object student_object = query.setParameter("rn", roll_number).getSingleResult();
            session.delete(student_object);
            System.out.println("Deleted!");
            session.getTransaction().commit();
        }catch (HibernateException e){
            e.printStackTrace();
        }
    }
}
