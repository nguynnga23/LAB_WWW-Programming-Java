package com.example.api;

import com.example.business.BaseProcess;
import com.example.models.Student;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/students")
public class StudentResource {
    @Inject
    private BaseProcess process;

    @GET
    @Produces("application/json")
    public List<Student> getAll(){
        return process.getAll();
    }

    @GET
    @Path("/{id}")
    public Response getByID(@PathParam("id") long id){
        Response.ResponseBuilder builder = Response.ok();
        builder.entity(process.getById(id));
        return builder.build();
    }
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response add(Student student){
        Response.ResponseBuilder builder = Response.ok();
        builder.entity(process.persist(student));
        return builder.build();
    }
}
