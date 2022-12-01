package com.example.departmentcrud.DriverClass;

import com.example.departmentcrud.Bean.Department;
import com.example.departmentcrud.Bean.Employee;
import com.example.departmentcrud.DAO.DAOImplementation.DepartmentDAOImpl;

import com.example.departmentcrud.DAO.DepartmentDAO;


import java.util.*;

public class Application {
    public static void main(String args[]){
        System.out.println("Application Started");
        runApplication();
        System.out.println("End");
    }


    private static void runApplication() {
        Department dept1= new Department(4,"faculty",50);
        DepartmentDAO deptDAO= new DepartmentDAOImpl();
        /*if(deptDAO.addDepartment(dept1)){
            System.out.println("department 1 added Successfully");
        }
        else{
            System.out.println("error");
        }*/
       // EmployeeDAO empDAO= new EmployeeDAOImpl();
        List<Department> dept=deptDAO.getDepartmentList();

        for(Department d:dept){
            System.out.println(d.getEmp_list());
        }

    }
}
