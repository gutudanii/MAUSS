package com.mauss.edu.service;

import com.mauss.edu.model.Students;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentsService {
    void saveStudent(Students students);
    void deleteStudentById(Long id);
    List<Students> getAllStudents();
}
