package com.JPAJakartaEE8.Entity;

import com.JPAJakartaEE8.EntityListener.AbstractEntityListener;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@Entity

@NamedQuery(name = Department.getAllDepartments,query ="select d from Department d" )
@NamedQuery(name = Department.getDepartmentNames,query = "select d.departmentName from Department d")

@AttributeOverride(name = "Id", column = @Column(name = "DEP_ID"))
@Table(name = "DEPARTMENTS")
@EntityListeners(value = AbstractEntityListener.class)
public class Department extends AbstractEntity {

    public static final String getDepartmentNames = "getDepartmentNames";
    public static final String getAllDepartments = "getAllDepartments";

    @NotEmpty(message = "Department Name Must have a value")
    @Size(max = 40,message = "department name must not exceed 40 char")
    @Column(name = "Department_Name")
    private String departmentName;

    @Transient
    private Integer departmentCode;

//    @OneToMany(mappedBy = "department")
//    private Collection<Employee> employees = new LinkedList<>();

    @OneToMany(mappedBy = "department")
    @MapKey(name = "Id")
    @OrderBy("employeeName desc")
    private Map<Long,Employee> employees = new HashMap<>();

    @ElementCollection
    @CollectionTable(name = "EMPLOYEE_RANK")
    @MapKeyJoinColumn(name = "EMP_ID")
    @Column(name = "Rank")
    private Map<Employee,Long> employeeRank = new HashMap<>();

    public Map<Employee, Long> getEmployeeRank() {
        return employeeRank;
    }

    public void setEmployeeRank(Map<Employee, Long> employeeRank) {
        this.employeeRank = employeeRank;
    }

    public Map<Long, Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Map<Long, Employee> employees) {
        this.employees = employees;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(Integer departmentCode) {
        this.departmentCode = departmentCode;
    }

//    public Collection<Employee> getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(Collection<Employee> employees) {
//        this.employees = employees;
//    }
}
