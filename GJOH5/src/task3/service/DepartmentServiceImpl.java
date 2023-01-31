package task3.service;

import task3.model.Department;

import java.util.List;

/**
 * Implementation of the interface for working with departments
 */
public class DepartmentServiceImpl implements DepartmentService {

    FileService fileService = new FileServiceImpl();

    @Override
    public void addDepartment(Department department) {
        List<Department> departments = fileService.readDepartmentFromFile();
        departments.add(department);
        fileService.saveDepartmentToFile(departments);
    }

    @Override
    public List<Department> getAllDepartments() {
        return fileService.readDepartmentFromFile();
    }
}
