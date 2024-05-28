package com.mauss.edu.service;

import com.mauss.edu.model.Departments;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentsService {

    void saveDepartment(Departments departments);
    void deleteDepartmentById(Long id);
    List<Departments> getAllDepartments();
    Departments disable(Long id);
}
