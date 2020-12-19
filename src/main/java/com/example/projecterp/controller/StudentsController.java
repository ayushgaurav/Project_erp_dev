package com.example.projecterp.controller;

import com.example.projecterp.bean.Students;
import com.example.projecterp.services.StudentsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.xdevapi.JsonArray;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/students")
public class StudentsController {

    @POST
    @Path("/register")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerStudent(Students student) {
        System.out.println(student.getFirst_name());
        StudentsService studentsService = new StudentsService();
        studentsService.addStudent(student);
        return Response.ok().build();
    }

    @GET
    @Path("/view/{id}")
    public Response viewStudent(@PathParam("id") String roll_number) {
//        System.out.println("Controller: " + roll_number);
        StudentsService studentsService = new StudentsService();
        studentsService.viewStudent(roll_number);
        return Response.ok().build();
    }

    @GET
    @Path("/viewAll")
    public Response viewStudent() throws JsonProcessingException {
        StudentsService studentsService = new StudentsService();
        List<Students> studentsList = studentsService.viewAllStudents();

        ObjectMapper mapper = new ObjectMapper();
        String jsonData = mapper.writeValueAsString(studentsList);

        return Response
                .ok()
                .entity(jsonData)
                .build();
    }

    @PUT
    @Path("/update")
    public Response updateStudent(Students student) {
        StudentsService studentsService = new StudentsService();
        studentsService.updateStudent(student);
        return Response.ok().build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteStudent(@PathParam("id") String roll_number) {
        StudentsService studentsService= new StudentsService();
        studentsService.deleteStudent(roll_number);
        return Response.ok().build();
    }

}
