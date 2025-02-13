package entities;

import javax.persistence.*;

@Entity // Marks this class as a Hibernate Entity
@Table(name = "employee") // Maps this entity to the "employee" table
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment for ID
    @Column(name = "emp_id") // Maps to column "emp_id" in DB
    private int empId;

    @Column(name = "emp_name", nullable = false) // Maps to column "emp_name"
    private String empName;

    // Default constructor (required by Hibernate)
    public Employee() {}

    // Parameterized constructor
    public Employee(int empId, String empName) {
        this.empId = empId;
        this.empName = empName;
    }

    // Getters and Setters
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}
