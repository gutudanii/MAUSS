package com.mauss.edu.service.impl;

import com.mauss.edu.model.Courses;
import com.mauss.edu.repository.CoursesRepository;
import com.mauss.edu.service.CoursesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CoursesServiceImpl implements CoursesService {

    @Autowired
    private final CoursesRepository coursesRepository;
    @Override
    public void saveCourse(Courses courses) {
        coursesRepository.save(courses);
    }
}
