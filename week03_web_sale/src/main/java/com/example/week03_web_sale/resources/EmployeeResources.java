package com.example.week03_web_sale.resources;

import com.example.week03_web_sale.models.Employee;
import com.example.week03_web_sale.services.EmployeeServices;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Path("/employees")
public class EmployeeResources {
    private final EmployeeServices employeeServices;
    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    public EmployeeResources() {
        employeeServices = new EmployeeServices();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getEmployee(@PathParam("id") int id) {
        Optional<Employee> employeeOpt = employeeServices.getEmployeeById(id);
        if (employeeOpt.isPresent()) {
            return Response.ok(employeeOpt.get()).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Employee employee) {
        employeeServices.insertEmployee(employee);
        return Response.ok(employee).build();
    }


    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        if(employeeServices.delete(id))
            return Response.ok().build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
