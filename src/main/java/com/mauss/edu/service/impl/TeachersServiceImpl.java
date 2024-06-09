package com.mauss.edu.service.impl;

import com.mauss.edu.model.Teachers;
import com.mauss.edu.repository.TeachersRepository;
import com.mauss.edu.service.TeachersService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeachersServiceImpl implements TeachersService {

    @Autowired
    private final TeachersRepository teachersRepository;

    @Override
    public void saveTeacher(Teachers teachers) {
        teachersRepository.save(teachers);
    }

    @Override
    public void deleteTeachById(Long id) {
        teachersRepository.deleteById(id);
    }

    @Override
    public List<Teachers> getAllTeachers() {
        return teachersRepository.findAll();
    }
}
