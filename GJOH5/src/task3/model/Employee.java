package task3.model;

import task3.model.enums.Position;

import java.util.Date;

/**
 * The class represents an employee in the organization
 */
public class Employee extends Person {
    private Department department;
    private final Position position;
    private final Date gotAJob;

    public Employee(String firstname, String lastname, Department department, Position position, Date gotAJob) {
        super(firstname, lastname);
        this.department = department;
        this.position = position;
        this.gotAJob = gotAJob;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Date getGotAJob() {
        return gotAJob;
    }

    @Override
    public String toString() {
        return this.getFirstname() + " " + this.getLastname() + " " + department.getName() + " " + position + " " + gotAJob;
    }
}
