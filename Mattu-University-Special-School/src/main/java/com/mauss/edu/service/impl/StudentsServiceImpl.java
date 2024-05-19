package com.mauss.edu.service.impl;

import com.mauss.edu.model.Students;
import com.mauss.edu.repository.StudentsRepository;
import com.mauss.edu.service.StudentsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentsServiceImpl implements StudentsService {

    @Autowired
    private final StudentsRepository studentsRepository;

    @Override
    public void saveStudent(Students students) {
        studentsRepository.save(students);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentsRepository.deleteById(id);
    }

    @Override
    public List<Students> getAllStudents() {
        return studentsRepository.findAll();
    }
}
