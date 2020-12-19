package com.example.projecterp.bean;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "Students")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer student_id;

    @NotNull
    @Column(unique=true)
    private String roll_number;

    @NotNull
    private String first_name;
    private String last_name;

    @NotNull
    @Column(unique=true)
    private String email;

    @NotNull
    private Integer total_credit;
    private Date graduation_year;

    public Students() {

    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public String getRoll_number() {
        return roll_number;
    }

    public void setRoll_number(String roll_number) {
        this.roll_number = roll_number;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTotal_credit() {
        return total_credit;
    }

    public void setTotal_credit(Integer total_credit) {
        this.total_credit = total_credit;
    }

    public Date getGraduation_year() {
        return graduation_year;
    }

    public void setGraduation_year(Date graduation_year) {
        this.graduation_year = graduation_year;
    }

    public Students(String roll_number, String first_name, String last_name, String email, Integer total_credit, Date graduation_year) {
        this.roll_number = roll_number;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.total_credit = total_credit;
        this.graduation_year = graduation_year;
    }
}
