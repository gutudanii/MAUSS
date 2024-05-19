package com.mauss.edu.service;

import com.mauss.edu.model.Courses;
import org.springframework.stereotype.Service;

@Service
public interface CoursesService {

    void saveCourse(Courses courses);
}
