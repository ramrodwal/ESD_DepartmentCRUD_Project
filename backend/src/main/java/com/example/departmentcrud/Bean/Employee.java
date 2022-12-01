package com.example.departmentcrud.Bean;

import jakarta.persistence.*;

@Entity
@Table(name ="employee")
public class Employee {
    @Id
    @Column(name ="employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employee_id;
    @Column(name="first_name",nullable = false)
    private String first_name;
    @Column(name="last_name",nullable = true)
    private String last_name;
    @Column(name="email",nullable = false, unique=true)
    private String email;
    @Column(name="title",nullable = true)
    private String title;
    @Column(name="photograph_path",nullable = true)
    private String photograph_path;
    @ManyToOne(optional=true)
    //@JoinColumn(name = "dept_id", referencedColumnName = "department_id")
    private Department department;

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", title='" + title + '\'' +
                ", photograph_path='" + photograph_path + '\'' +
                ", department=" + department +
                '}';
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee() {

    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhotograph_path() {
        return photograph_path;
    }

    public void setPhotograph_path(String photograph_path) {
        this.photograph_path = photograph_path;
    }
}
