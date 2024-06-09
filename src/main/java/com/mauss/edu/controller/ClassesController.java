package com.mauss.edu.controller;

import com.mauss.edu.model.Classes;
import com.mauss.edu.service.ClassesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class ClassesController {

    @Autowired
    private final ClassesService classesService;

    @PostMapping("/class/save")
    public String saveClass(@ModelAttribute Classes classes,
                            @RequestParam("acaId") String acaId) {
        classes.setAcaId(acaId);
        classes.setEnd(true);
        classesService.saveClasses(classes);
        return "redirect:/dashboard";
    }

}
