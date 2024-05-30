package com.mauss.edu.service.impl;

import com.mauss.edu.model.Classes;
import com.mauss.edu.repository.ClassesRepository;
import com.mauss.edu.service.ClassesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    private final ClassesRepository classesRepository;

    @Override
    public void saveClasses(Classes classes) {
        classes.setClassId(classes.getAcaId() + "-GR-" + classes.getClassNo() + "-" + classes.getId());
        classesRepository.save(classes);
    }

    @Override
    public Classes end(Long id) {
        Classes classes = classesRepository.findById(id).get();
        classes.setEnd(true);
        classesRepository.save(classes);
        return classes;
    }

    @Override
    public Classes notEnd(Long id) {
        Classes classes = classesRepository.findById(id).get();
        classes.setEnd(false);
        classesRepository.save(classes);
        return classes;
    }
}
