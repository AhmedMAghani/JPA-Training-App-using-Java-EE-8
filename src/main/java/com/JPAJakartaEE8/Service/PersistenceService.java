package com.JPAJakartaEE8.Service;

import com.JPAJakartaEE8.Entity.AbstractEntity;
import com.JPAJakartaEE8.Entity.Employee;
import com.JPAJakartaEE8.Entity.ParkingSpace;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@DataSourceDefinition(
        name = "java:global/JPAJakartaEE8/jakartaEE8",
        className = "oracle.jdbc.driver.OracleDriver",
        url = "jdbc:oracle:thin:jakartaEE8/manar@localhost:1521:XE")
@Stateless
public class PersistenceService<T extends AbstractEntity> {

    private final EntityManager entityManager;

    private final QueryService queryService;

    @Inject
    public PersistenceService(EntityManager entityManager, QueryService queryService) {
        this.entityManager = entityManager;
        this.queryService = queryService;
    }

    public AbstractEntity save(T newDatabaseRow){
        entityManager.persist(newDatabaseRow);
        return newDatabaseRow;
    }

    public AbstractEntity remove(T newDatabaseRow){
        entityManager.remove(newDatabaseRow);
        return newDatabaseRow;
    }

    public void removeParkingSpace(Long id){
        Employee parkingSpaceEmployee = queryService.findEmployeeById(id);
        parkingSpaceEmployee.setCurrentParkingSpace(null);
        entityManager.remove(parkingSpaceEmployee.getCurrentParkingSpace());
    }

    public Employee saveEmployee(Employee employee,ParkingSpace parkingSpace){
        employee.setCurrentParkingSpace(parkingSpace);
        entityManager.persist(employee);
        return employee;
    }

    public AbstractEntity update(T updatedDatabaseRow){
        entityManager.merge(updatedDatabaseRow);
        return updatedDatabaseRow;
    }
}
