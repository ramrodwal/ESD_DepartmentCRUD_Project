package com.example.departmentcrud.Bean;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="department")
public class Department {
    @Id
    @Column(name ="dept_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int department_id;
    @Column(name="name",nullable = false)
    private String name;
    @Column(name="capacity",nullable = false)
    private int capacity;
    @OneToMany(mappedBy = "department",cascade = { CascadeType.REMOVE })
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Employee> emp_list=new ArrayList<>();

    public Department() {
    }

    @Override
    public String toString() {
        return "Department{" +
                "department_id=" + department_id +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", emp_list=" + emp_list +
                '}';
    }

    public Department(int department_id, String name, int capacity) {
        this.department_id = department_id;
        this.name = name;
        this.capacity = capacity;
    }

    public List<Employee> getEmp_list() {
        return emp_list;
    }

    public void setEmp_list(List<Employee> emp_list) {
        this.emp_list = emp_list;
    }

    public Department(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
