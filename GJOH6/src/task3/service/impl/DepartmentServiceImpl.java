package task3.service.impl;

import task3.model.Department;
import task3.service.DepartmentService;
import task3.service.FileServiceDepartment;

import java.util.List;

/**
 * Implementation of the interface for working with departments
 */
public class DepartmentServiceImpl implements DepartmentService {

    FileServiceDepartment fileService = new FileServiceDepartmentImpl();

    @Override
    public void addDepartment(Department department, String filename) {
        List<Department> departments = fileService.readFromFile(filename);
        departments.add(department);
        fileService.saveToFile(departments, filename);
    }
}
