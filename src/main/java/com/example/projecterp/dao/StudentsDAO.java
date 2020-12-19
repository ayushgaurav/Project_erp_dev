package com.example.projecterp.dao;

import com.example.projecterp.bean.Students;

import java.util.List;

public interface StudentsDAO {
    public abstract void addStudent(Students student);
    public abstract List<Students> viewAllStudents();
    public abstract Students viewStudent(String roll_number);
    public abstract void updateStudent(Students student);
    public abstract void deleteStudent(String roll_number);
}
