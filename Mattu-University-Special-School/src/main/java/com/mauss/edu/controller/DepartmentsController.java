package com.mauss.edu.controller;

import com.mauss.edu.model.Departments;
import com.mauss.edu.service.DepartmentsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class DepartmentsController {

    @Autowired
    private final DepartmentsService departmentsService;

    @PostMapping("department/save")
    public String saveDepartment(@ModelAttribute Departments departments){
        departmentsService.saveDepartment(departments);
        return "redirect:/dashboard";
    }
}
