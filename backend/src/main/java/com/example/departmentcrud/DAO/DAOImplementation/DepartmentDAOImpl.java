package com.example.departmentcrud.DAO.DAOImplementation;

import com.example.departmentcrud.Bean.Department;
import com.example.departmentcrud.Bean.Employee;
import com.example.departmentcrud.DAO.DepartmentDAO;
import com.example.departmentcrud.Util.HibernateSessionUtil;
import jakarta.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;


public class DepartmentDAOImpl implements DepartmentDAO {


    public boolean addDepartment(Department deptObj){
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(deptObj);
            transaction.commit();
            return true;
        }
        catch (HibernateException exception) {
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }

    public Department getDepartment(int dept_id) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Department department = new Department();
            List<Employee> emp = new ArrayList<>();
            List<Employee> emp1 = new ArrayList<>();
            for (final Object d : session.createQuery("from Department d where d.department_id= " + dept_id).list()) {
                department = (Department) d;
            }
            for (final Object e : session.createQuery("from Employee e where e.department.department_id= " + dept_id).list()) {
                emp.add((Employee) e);
            }
            for (Employee e:emp){
                e.setDepartment(null);
            }
            department.setEmp_list(emp);
            return department;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }


    public boolean deleteDepartment(int dept_id){
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();
            Query q = session.createQuery("delete Department where department_id="+dept_id);
            q.executeUpdate();
            transaction.commit();
            return true;
        }
        catch (HibernateException exception) {
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public boolean updateDepartment(Department dept) {
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();
            String deptname= dept.getName();
            Query q=session.createQuery("update Department set name=:deptname, capacity="+dept.getCapacity()+" where department_id="+dept.getDepartment_id());
            q.setParameter("deptname",deptname);
            q.executeUpdate();
            transaction.commit();
            return true;
        }
        catch (HibernateException exception) {
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }

    public List<Department> getDepartmentList(){
        try (Session session = HibernateSessionUtil.getSession()) {
            List<Department> deptList = new ArrayList<>();
            for (final Object d : session.createQuery("from Department ").list()) {
                deptList.add((Department) d);
            }
            for(Department d:deptList){
                d.setEmp_list(null);
            }
            return deptList;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }
}
