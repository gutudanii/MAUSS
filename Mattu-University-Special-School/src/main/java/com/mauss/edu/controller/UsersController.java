package com.mauss.edu.controller;

import com.mauss.edu.model.*;
import com.mauss.edu.repository.AcademicRepository;
import com.mauss.edu.repository.ClassesRepository;
import com.mauss.edu.repository.CoursesRepository;
import com.mauss.edu.repository.UsersRepository;
import com.mauss.edu.service.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class UsersController {

    @Autowired
    private final UsersService usersService;
    @Autowired
    private final ClassesRepository classesRepository;
    @Autowired
    private final CoursesRepository coursesRepository;
    @Autowired
    private final MaterialsService materialsService;
    @Autowired
    private final RegistrarService registrarService;
    @Autowired
    private final UsersRepository usersRepository;
    @Autowired
    private final DepartmentsService departmentsService;
    @Autowired
    private final TeachersService teachersService;
    @Autowired
    private final StudentsService studentsService;
    @Autowired
    private final AcademicRepository academicRepository;

    @GetMapping("/users/all")
    @ResponseBody
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping("/")
    public String ger(Principal principal){
        if (principal != null){
            return "redirect:/home";
        }
        return "landing.html";
    }
    @GetMapping("/users/login")
    public String getUsersHtml(){
        return "redirect:/";
    }
    @GetMapping("/home")
    public String getHome(){
        return "home.html";
    }
    @GetMapping("/dashboard")
    public String getPage(Principal principal, Users users, Model model){
        Users users1 = usersRepository.findByUsername(principal.getName()).get();
        if (users1.getRole().equals("student")){
            model.addAttribute("usrFName", users1.getFName());
            List<Materials> getAllMaterials  = materialsService.getAllMaterials();
            model.addAttribute("materials", getAllMaterials);
            return "/student.html";
        }
        else if (users1.getRole().equals("teacher")){
            Materials material = new Materials();
            model.addAttribute("materials", material);
            model.addAttribute("materialList", materialsService.getAllMaterials());
            return "/teacher.html";
        }
        else if (users1.getRole().equals("registrar")){
            List<Users> students = usersRepository.findAllUsersByRole("student");
            List<Users> teachers = usersRepository.findAllUsersByRole("teacher");

            Departments departments = new Departments();
            Academic academics = new Academic();
            Classes classes = new Classes();
            Courses courses = new Courses();

            List<Courses> getAllGrade9 = coursesRepository.getAllByTargetGrade("grade-9");
            List<Courses> getAllGrade10 = coursesRepository.getAllByTargetGrade("grade-10");
            List<Courses> getAllGrade11 = coursesRepository.getAllByTargetGrade("grade-11");
            List<Courses> getAllGrade12 = coursesRepository.getAllByTargetGrade("grade-12");

            List<Academic> getAllAcademic = academicRepository.findAll();

            List<Users> getAllStudentTeach = new ArrayList<>(students);
            getAllStudentTeach.addAll(teachers);

            List<Classes> getAllClasses = classesRepository.findAll();

            Map<String, List<Classes>> classesByAcademicId = getAllAcademic.stream()
                    .collect(Collectors.toMap(
                            Academic::getAcademicId,
                            academic -> classesRepository.getAllByAcaId(academic.getAcademicId())
                    ));


            model.addAttribute("academics", getAllAcademic);
            model.addAttribute("classesByAcademicId", classesByAcademicId);
            model.addAttribute("grade9lst", getAllGrade9);
            model.addAttribute("grade10lst", getAllGrade10);
            model.addAttribute("grade11lst", getAllGrade11);
            model.addAttribute("grade12lst", getAllGrade12);

            model.addAttribute("users", getAllStudentTeach);
            model.addAttribute("user", users);
            model.addAttribute("teachers", teachers);
            model.addAttribute("department", departments);
            model.addAttribute("academic", academics);
            model.addAttribute("classes", classes);
            model.addAttribute("course", courses);
            model.addAttribute("reports", "rp");
            model.addAttribute("studentsList", students);
            return "/registrar.html";
        }
        else if (users1.getRole().equals("department")){

            return "/department.html";
        }
        else if (users1.getRole().equals("admin")){
            model.addAttribute("usrFName", users1.getFName());
            model.addAttribute("user", users);
            model.addAttribute("users", usersService.getAllUsers());
            int stuSize = usersRepository.findAllUsersByRole("student").size();
            int teachSize = usersRepository.findAllUsersByRole("teacher").size();
            int regSize = usersRepository.findAllUsersByRole("registrar").size();
            int allUser = usersService.getAllUsers().size();
            model.addAttribute("stuS", stuSize);
            model.addAttribute("teachS", teachSize);
            model.addAttribute("regS", regSize);
            model.addAttribute("allS", allUser);
            return "/admin.html";
        }
        return "/users/login";
    }
    @GetMapping("/users/create")
    public String create(Model model, Users users){
        model.addAttribute("users", users);
        return "/regist.html";
    }
    @PostMapping("/users/save")
    public String saveUser(@ModelAttribute Users users){
        usersService.saveUser(users);
        return "redirect:/dashboard";
    }

}
