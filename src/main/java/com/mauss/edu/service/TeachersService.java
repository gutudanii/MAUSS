package com.mauss.edu.service;

import com.mauss.edu.model.Teachers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeachersService {
    void saveTeacher(Teachers teachers);
    void deleteTeachById(Long id);
    List<Teachers> getAllTeachers();
}
