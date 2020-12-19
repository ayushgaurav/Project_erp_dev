package com.example.projecterp.dao.impl;

import com.example.projecterp.bean.Students;
import com.example.projecterp.dao.StudentsDAO;
import com.example.projecterp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class StudentsDAOImpl implements StudentsDAO {
    Students new_student = new Students();
    Query<Students> query;
    List<Students> students;

    @Override
    public void addStudent(Students student) {
        System.out.println(student.getEmail());
        try(Session session = SessionUtil.getSession()){
            session.beginTransaction();
            //Generate roll number
            Query<Students> query = session.createQuery("select max(s.student_id) from Students s",Students.class);
            List<Students> latest_student_id = query.list();
            System.out.println("Result: " + latest_student_id);
//            student.setRoll_number("MT" + String.valueOf(Integer.parseInt(latest_student_id)+1));
            System.out.println("Roll number --> " + student.getRoll_number());

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
