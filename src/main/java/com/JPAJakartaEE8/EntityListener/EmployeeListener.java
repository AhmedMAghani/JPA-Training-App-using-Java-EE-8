package com.JPAJakartaEE8.EntityListener;

import com.JPAJakartaEE8.Entity.Employee;

import javax.persistence.PrePersist;
import java.time.LocalDate;
import java.time.Period;

public class EmployeeListener {

    @PrePersist
    private void calculateEmployeeAge(Employee employee){
        if (employee.getAge() == null)
            employee.setAge(Period.between(employee.getDateOfBirth(), LocalDate.now()).getYears());
    }
}
