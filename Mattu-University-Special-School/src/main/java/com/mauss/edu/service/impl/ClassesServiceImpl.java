package com.mauss.edu.service.impl;

import com.mauss.edu.model.Classes;
import com.mauss.edu.repository.ClassesRepository;
import com.mauss.edu.service.ClassesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    private final ClassesRepository classesRepository;

    @Override
    public void saveClasses(Classes classes) {
        classes.setClassId(classes.getAcaId() + "-GR-" + classes.getClassNo());
        classesRepository.save(classes);
    }
}
