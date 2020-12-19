package com.example.projecterp.services;

import com.example.projecterp.bean.Students;
import com.example.projecterp.dao.StudentsDAO;
import com.example.projecterp.dao.impl.StudentsDAOImpl;

import java.util.List;

public class StudentsService {
    public void addStudent(Students student){
        System.out.println(student.getLast_name());
        new StudentsDAOImpl().addStudent(student);
    }

    public List<Students> viewAllStudents(){
        List<Students> students = new StudentsDAOImpl().viewAllStudents();
        return students;
    }

    public Students viewStudent(String roll_number){
    //System.out.println("Service: " + roll_number);
        Students student = new StudentsDAOImpl().viewStudent(roll_number);
        return  student;
    }

    public void updateStudent(Students student){
        new StudentsDAOImpl().updateStudent(student);
    }

    public void deleteStudent(String roll_number){
        new StudentsDAOImpl().deleteStudent(roll_number);
    }
}
