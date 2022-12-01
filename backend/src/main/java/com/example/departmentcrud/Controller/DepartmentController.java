package com.example.departmentcrud.Controller;

import com.example.departmentcrud.Bean.Department;
import com.example.departmentcrud.DAO.DAOImplementation.DepartmentDAOImpl;
import com.example.departmentcrud.DAO.DepartmentDAO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/department")
public class DepartmentController {
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addDepartment(Department dept){
        DepartmentDAO deptDAO = new DepartmentDAOImpl();
        System.out.printf(String.valueOf(dept));
        if(deptDAO.addDepartment(dept)){
            return Response.status(201).entity("Created").build();
        }
        return Response.status(500).entity("Failure while adding department").build();
    }
    @GET
    @Path("/get/{dept_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDepartment(@PathParam("dept_id") int dept_id){
        DepartmentDAO deptDAO = new DepartmentDAOImpl();
        Department dept=deptDAO.getDepartment(dept_id);
        if(dept==null){
            return Response.status(400).entity("Failure while fetching department").build();
        }
        else{
            return Response.status(200).entity(dept).build();
        }
    }
    @DELETE
    @Path("/delete/{dept_id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteDepartment(@PathParam("dept_id") int dept_id){
        DepartmentDAO deptDAO = new DepartmentDAOImpl();
        if(deptDAO.deleteDepartment(dept_id)){
            return Response.status(200).entity("Success").build();
        }
        else{
            return Response.status(400).entity("Failure while deleting department").build();
        }
    }

    @PUT
    @Path("/update/{dept_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteDepartment(@PathParam("dept_id") int dept_id, Department dept){
        dept.setDepartment_id(dept_id);
        DepartmentDAO deptDAO = new DepartmentDAOImpl();
        if(deptDAO.updateDepartment(dept)){
            return Response.status(200).entity("Success").build();
        }
        else{
            return Response.status(400).entity("Failure while updating department").build();
        }
    }

    @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDepartmentList(){
        DepartmentDAO deptDAO = new DepartmentDAOImpl();
        List<Department> deptList=deptDAO.getDepartmentList();
        return Response.status(200).entity(deptList).build();
    }
}
