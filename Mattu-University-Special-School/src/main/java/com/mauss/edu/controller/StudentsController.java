package com.mauss.edu.controller;

import com.mauss.edu.model.Classes;
import com.mauss.edu.model.Students;
import com.mauss.edu.model.Users;
import com.mauss.edu.repository.ClassesRepository;
import com.mauss.edu.repository.StudentsRepository;
import com.mauss.edu.repository.UsersRepository;
import com.mauss.edu.service.StudentsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@AllArgsConstructor
public class StudentsController {

    @Autowired
    private final StudentsService studentsService;
    @Autowired
    private final StudentsRepository studentsRepository;
    @Autowired
    private final UsersRepository usersRepository;
    @Autowired
    private final ClassesRepository classesRepository;

    @GetMapping("/students/update/{uniqueId}")
    public String getUpdatePage(@PathVariable String uniqueId, Model model){
        Students students = studentsRepository.findByUniqueId(uniqueId).get();
        Users users = usersRepository.findByUniqueId(uniqueId).get();
        model.addAttribute("usersInfo", users);
        model.addAttribute("students", students);
        List<Classes> getAllClasses = classesRepository.findAll();
        model.addAttribute("gradesList", getAllClasses);

        return "/studentsUpdate.html";
    }
    @PostMapping("/{uniqueId}/edit/students")
    public String saveStudents(@PathVariable("uniqueId")String uniqueId, @ModelAttribute Students students,
                               @RequestParam("material") MultipartFile material) throws IOException {
                students.setImage(material.getBytes());
                students.setImageName(material.getOriginalFilename());
        studentsService.updateStudents(students, uniqueId);
        return "redirect:/dashboard";
    }
    @GetMapping("/students/list/{clsId}")
    public String getAllStudentsByClass(@PathVariable("clsId")String clsId, Model model){
        List<Students> getAllStudents = studentsRepository.getByClassId(clsId);
        model.addAttribute("studentsList", getAllStudents);
        return "/studentsView.html";
    }
}
