package com.JPAJakartaEE8.Entity;

import com.JPAJakartaEE8.EntityListener.AbstractEntityListener;
import com.JPAJakartaEE8.EntityListener.EmployeeListener;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

//********************************Named_quires************************************************
@NamedQuery(name = Employee.getEmployeeAllowances,query = "select al from Employee e join e.allowanceSet al")
@NamedQuery(name = Employee.getEmployeePhones,query = "select e.employeeName, KEY(ph),VALUE(ph) from Employee e join e.employeePhoneNumbers ph")
@NamedQuery(name = Employee.getEmployeeWithAllowance,query = "select e from Employee e join fetch e.allowanceSet")
@NamedQuery(name = Employee.getCurrentparkingSpaceLotNumber,query = "select e.currentParkingSpace.parkingLotNumber from Employee e")
@NamedQuery(name = Employee.getEmployeeNameAndSalary,query = "select e.employeeName,e.employeeSalary from Employee e")
@NamedQuery(name = Employee.getEmployeeDetails,query = "select new com.JPAJakartaEE8.Entity.EmpDetails(e.employeeName,e.employeeSalary,e.department.departmentName) from Employee e")
//***********************************************************************************************
//*********************************Native_quires************************************************
@NamedNativeQuery(name = Employee.getAllEmployeesNative,query = "select * from employees",resultClass = Employee.class)

@Entity
@AttributeOverride(name = "Id",column = @Column(name = "EMP_ID"))
@Table(name = "Employees")
@EntityListeners(value = {AbstractEntityListener.class, EmployeeListener.class})
public class Employee extends AbstractEntity {

    public static final String getAllEmployeesNative = "getAllEmployeesNative";

    public static final String getEmployeeAllowances = "getEmployeeAllowances";
    public static final String getEmployeeWithAllowance = "getEmployeeWithAllowance";
    public static final String getEmployeePhones = "getEmployeePhones";
    public static final String getEmployeeDetails = "getEmployeeDetails";
    public static final String getCurrentparkingSpaceLotNumber = "getCurrentparkingSpaceLotNumber";
    public static final String getEmployeeNameAndSalary = "getEmployeeNameAndSalary";

    @Column(name = "employee_Name")
    private String employeeName;

    @Column(name = "employee_Salary")
    @DecimalMin(value = "500",message = "salary must be greater or equal than 500")
    private BigDecimal employeeSalary;

    @ManyToOne
    @JoinColumn(name = "EMP_DEP")
    private Department department;

    @OneToOne
    @JoinColumn(name = "CURRENT_PAYSLIP")
    private Payslip currentPayslip;

    @OneToOne(mappedBy = "employee", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private ParkingSpace currentParkingSpace;

    @ManyToMany(mappedBy = "employees")
    private Collection<Project> projects = new LinkedList<>();

    @Past(message = "please enter a valed past date")
    @NotEmpty(message = "the date of  birth must be set")
    @JsonbDateFormat("dd-MM-yyyy")
    @Column(name = "DATE_OF_BIRTH")
    private LocalDate dateOfBirth;

    @Column(name = "HIRE_DATE")
    @JsonbDateFormat("dd-MM-yyyy")
    @PastOrPresent(message = "Date must be in the past or present")
    private LocalDate hireDate;

    @ManyToOne
    @JoinColumn(name = "REPORT_TO")
    private Employee reportTo;

    @OneToMany(mappedBy = "reportTo")
    private Collection<Employee> subordinates = new HashSet<>();

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinTable(
            name = "EMP_ALLOWANCE",
            joinColumns = @JoinColumn(name = "Employee_ID"),
            inverseJoinColumns = @JoinColumn(name = "allowance_ID")
    )
    private Set<Allowance> allowanceSet = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "nicknames",joinColumns = @JoinColumn(name = "EMP_ID"))
    @Column(name = "nickname")
    private Collection<String> nickNames;

    @Embedded
    @AttributeOverride(name = "streetAddress", column = @Column(name = "street_address"))
    @AttributeOverride(name = "zipCode", column =  @Column(name = "zip_code"))
    private Address address;

    @ElementCollection
    @CollectionTable(name = "Emp_Qualifications",joinColumns = @JoinColumn(name = "EMP_ID"))
    @AttributeOverride(name = "dateCompleted",column = @Column(name = "date_completed"))
    @AttributeOverride(name = "qualificationAwarded", column =  @Column(name = "qualification_awarded"))
    private Collection<Qualification> qualifications;

    @ElementCollection
    @CollectionTable(name = "Phones")
    @MapKeyColumn(name = "Phone_type")
    @Column(name = "Phone_number")
    @MapKeyEnumerated(EnumType.STRING)
    private Map<PhoneType,String> employeePhoneNumbers;

    @DecimalMax(value = "60",message = "age must be less than or equal 60")
    private Integer age;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "employee_type")
    private EmployeeType employeeType;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] image;


    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public BigDecimal getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(BigDecimal employeeSalary) {
        this.employeeSalary = employeeSalary;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Payslip getCurrentPayslip() {
        return currentPayslip;
    }

    public void setCurrentPayslip(Payslip currentPayslip) {
        this.currentPayslip = currentPayslip;
    }

    public ParkingSpace getCurrentParkingSpace() {
        return currentParkingSpace;
    }

    public void setCurrentParkingSpace(ParkingSpace currentParkingSpace) {
        this.currentParkingSpace = currentParkingSpace;
    }

    public Map<PhoneType, String> getEmployeePhoneNumbers() {
        return employeePhoneNumbers;
    }

    public void setEmployeePhoneNumbers(Map<PhoneType, String> employeePhoneNumbers) {
        this.employeePhoneNumbers = employeePhoneNumbers;
    }

    public Employee getReportTo() {
        return reportTo;
    }

    public void setReportTo(Employee reportTo) {
        this.reportTo = reportTo;
    }

    public Collection<Employee> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(Collection<Employee> subordinates) {
        this.subordinates = subordinates;
    }

    public Set<Allowance> getAllowanceSet() {
        return allowanceSet;
    }

    public void setAllowanceSet(Set<Allowance> allowanceSet) {
        this.allowanceSet = allowanceSet;
    }

    public Collection<String> getNickNames() {
        return nickNames;
    }

    public void setNickNames(Collection<String> nickNames) {
        this.nickNames = nickNames;
    }

    public Collection<Qualification> getQualifications() {
        return qualifications;
    }

    public void setQualifications(Collection<Qualification> qualifications) {
        this.qualifications = qualifications;
    }

    public Collection<Project> getProjects() {
        return projects;
    }

    public void setProjects(Collection<Project> projects) {
        this.projects = projects;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    //    @PrePersist
//    private void beforPersist(){
//        if (this.age == null)
//            this.age = Period.between(dateOfBirth,LocalDate.now()).getYears();
//    }
}
