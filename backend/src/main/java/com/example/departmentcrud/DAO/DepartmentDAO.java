package com.example.departmentcrud.DAO;

import com.example.departmentcrud.Bean.Department;

import java.util.List;

public interface DepartmentDAO {
    boolean addDepartment(Department deptObj);
    Department getDepartment(int dept_id);

    boolean deleteDepartment(int dept_id);
    boolean updateDepartment(Department dept);

    List<Department> getDepartmentList();

}
