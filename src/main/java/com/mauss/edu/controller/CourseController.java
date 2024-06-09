package com.mauss.edu.controller;

import com.mauss.edu.model.Courses;
import com.mauss.edu.service.CoursesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class CourseController {

    @Autowired
    private final CoursesService coursesService;

    @PostMapping("courses/save")
    public String saveCourse(@ModelAttribute Courses courses){

        coursesService.saveCourse(courses);
        return "redirect:/dashboard";
    }
}
