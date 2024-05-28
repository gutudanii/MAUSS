package com.mauss.edu.controller;

import com.mauss.edu.model.Academic;
import com.mauss.edu.model.Classes;
import com.mauss.edu.repository.ClassesRepository;
import com.mauss.edu.service.AcademicService;
import com.mauss.edu.service.ClassesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class AcademicController {

    @Autowired
    private final AcademicService academicService;
    @Autowired
    private final ClassesService classesService;
    @Autowired
    private final ClassesRepository classesRepository;

    @PostMapping("academic/save")
    public String addAcademic(@ModelAttribute Academic academic){
        academic.setEnd(true);
        academicService.saveAcademic(academic);
        return "redirect:/dashboard";
    }
    @RequestMapping(path = {"/academic/end","/academic/end/{acadId}"})
    public String endAcademic(@PathVariable("acadId") String acadId){
        academicService.end(acadId);
        if (classesRepository.getByAcaId(acadId).isPresent()){
        classesService.end(acadId);
        }
        return "redirect:/dashboard";
    }
    @RequestMapping(path = {"/academic/NotEnd","/academic/NotEnd/{acadId}"})
    public String NotEndAcademic(@PathVariable("acadId") String acadId){
        academicService.notEnd(acadId);
        if (classesRepository.getByAcaId(acadId).isPresent()){
            classesService.notEnd(acadId);
        }
        return "redirect:/dashboard";
    }
    @RequestMapping(path = {"/delete/academic", "/delete/academic/{id}"})
    public String deleteAca(@PathVariable("id")Long id){
        academicService.deleteAcademic(id);
        return "/redirect:/dashboard";
    }

}
