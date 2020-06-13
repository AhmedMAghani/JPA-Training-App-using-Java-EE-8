package com.JPAJakartaEE8.Entity;

import javax.persistence.*;

@Entity
@AttributeOverride(name = "Id",column = @Column(name = "PARK_ID"))
@Table(name = "PARKING_SPACE")
public class ParkingSpace extends AbstractEntity {
    @Column(name = "parking_Lot_Number")
    private String parkingLotNumber;

    @OneToOne
    @JoinColumn(name = "parking_space_emp")
    private Employee employee;

    public String getParkingLotNumber() {
        return parkingLotNumber;
    }

    public void setParkingLotNumber(String parkingLotNumber) {
        this.parkingLotNumber = parkingLotNumber;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
