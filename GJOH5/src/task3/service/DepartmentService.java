package task3.service;

import task3.model.Department;

import java.util.List;

/**
 * The interface contains methods for working with departments
 */
public interface DepartmentService {

    void addDepartment(Department department);

    List<Department> getAllDepartments();
}
