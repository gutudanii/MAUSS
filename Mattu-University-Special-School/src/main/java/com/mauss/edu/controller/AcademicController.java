package com.mauss.edu.controller;

import com.mauss.edu.model.Academic;
import com.mauss.edu.service.AcademicService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AcademicController {

    @Autowired
    private final AcademicService academicService;

    @PostMapping("academic/save")
    public String addAcademic(@ModelAttribute Academic academic){
        academicService.saveAcademic(academic);
        return "redirect:/dashboard";
    }
}
