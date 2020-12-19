package com.example.projecterp.bean;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@Table(name = "Domains")
public class Domains {

    public Domains(String program, Date batch, Integer capacity, String qualification) {
        this.program = program;
        this.batch = batch;
        this.capacity = capacity;
        this.qualification = qualification;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer domain_id;

    @NotNull
    private String program;

    @NotNull
    private Date batch;

    @NotNull
    private Integer capacity;

    private String qualification;

    public Domains() {

    }

    public Integer getDomain_id() {
        return domain_id;
    }

    public void setDomain_id(Integer domain_id) {
        this.domain_id = domain_id;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public Date getBatch() {
        return batch;
    }

    public void setBatch(Date batch) {
        this.batch = batch;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

}
