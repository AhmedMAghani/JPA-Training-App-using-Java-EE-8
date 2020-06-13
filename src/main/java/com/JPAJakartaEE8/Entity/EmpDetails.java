package com.JPAJakartaEE8.Entity;


import java.math.BigDecimal;

public class EmpDetails {
    private String fullName;
    private BigDecimal salary;
    private String departmentName;

    public EmpDetails(String fullName, BigDecimal salary, String departmentName) {
        this.fullName = fullName;
        this.salary = salary;
        this.departmentName = departmentName;
    }

    public EmpDetails() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}