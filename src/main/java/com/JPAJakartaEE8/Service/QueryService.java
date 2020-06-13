package com.JPAJakartaEE8.Service;

import com.JPAJakartaEE8.Entity.Allowance;
import com.JPAJakartaEE8.Entity.Department;
import com.JPAJakartaEE8.Entity.EmpDetails;
import com.JPAJakartaEE8.Entity.Employee;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.List;

@Stateless
public class QueryService {
    private final EntityManager entityManager;

    @Inject
    public QueryService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // lifecycle hookup for ejb this lifecycle method is exists in stateless, singleton and stateful
    // invoked after all the dependence are injected successfully into the been
    @PostConstruct
    public void postConstruct(){

    }

    // lifecycle hookup for ejb this lifecycle method is exists in stateless, singleton and stateful
    // invoked befor the been become available to the garbage collection
    @PreDestroy
    public void preDestroy(){

    }

    public Department findDepartmentById(Long id){
        return entityManager.find(Department.class,id);
    }

    public Employee findEmployeeById(Long id){
        return entityManager.find(Employee.class,id);
    }

    public List<Employee> getEmployees(){
        return null;
    }

    public List<String> getDepartmentNames(){
        return entityManager.createNamedQuery(Department.getDepartmentNames,String.class).getResultList();
    }

    public String getEmpParkingLotNumber(){
        return entityManager.createNamedQuery(Employee.getCurrentparkingSpaceLotNumber,String.class).getSingleResult();
    }

    public Collection<Object[]> getEmpNameAndSalary(){
        return entityManager.createNamedQuery(Employee.getEmployeeNameAndSalary,Object[].class).getResultList();
    }

    public Collection<EmpDetails> getEmployeeDetails(){
        return entityManager.createNamedQuery(Employee.getEmployeeDetails,EmpDetails.class).getResultList();
    }

    public List<Department> getDepartments(){
        return entityManager.createNamedQuery(Department.getAllDepartments,Department.class).getResultList();
    }

    public Collection<Employee> getEmployeeWithAllowance(){
        return entityManager.createNamedQuery(Employee.getEmployeeWithAllowance,Employee.class).getResultList();
    }

    public Collection<Allowance> getEmployeeAllowance(){
        return entityManager.createNamedQuery(Employee.getEmployeeAllowances,Allowance.class).getResultList();
    }

    public Collection<Object[]> getEmployeePhones(){
        return entityManager.createNamedQuery(Employee.getEmployeePhones,Object[].class).getResultList();
    }

    public Collection<Employee> getAllEmployeesNative(){
        return entityManager.createNamedQuery(Employee.getAllEmployeesNative,Employee.class).getResultList();
    }
}
