package com.mauss.edu.service.impl;

import com.mauss.edu.model.Departments;
import com.mauss.edu.repository.DepartmentsRepository;
import com.mauss.edu.service.DepartmentsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentsServiceImpl implements DepartmentsService {

    @Autowired
    private final DepartmentsRepository departmentsRepository;

    @Override
    public void saveDepartment(Departments departments) {
        departmentsRepository.save(departments);
    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentsRepository.deleteById(id);
    }

    @Override
    public List<Departments> getAllDepartments() {
        return departmentsRepository.findAll();
    }
}
