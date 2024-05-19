//package com.mauss.edu.controller;
//
//import com.mauss.edu.model.*;
//import com.mauss.edu.service.*;
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@AllArgsConstructor
//public class UsersControllers {
//
//    @Autowired
//    private final UsersService usersService;
//    @Autowired
//    private final AdminsService adminsService;
//    @Autowired
//    private final RegistrarService registrarService;
//    @Autowired
//    private final DepartmentsService departmentsService;
//    @Autowired
//    private final TeachersService teachersService;
//    @Autowired
//    private final StudentsService studentsService;
//
//    @GetMapping("/getAllUsers")
//    public void getAllUser(){
//        usersService.getAllUsers();
//    }
//    @GetMapping("/users/login")
//    public String getUsersHtml(){
//        return "landing.html";
//    }
//    @GetMapping("/users/create")
//    public String create(Model model, Users users){
//        model.addAttribute("users", users);
//        return "/regist.html";
//    }
//    @PostMapping("users/save")
//    public String saveUser(@ModelAttribute Users users){
//        if(users.getRole().equals("admin")){
//            Admins admins = new Admins();
//            admins.setUniqueId(users.getUniqueId());
//            admins.setSecEnabled(false);
//            admins.setEnabled(true);
//            adminsService.saveAdmin(admins);
//        }
//        else if(users.getRole().equals("registrar")){
//            Registrar registrar = new Registrar();
//            registrar.setUniqueId(users.getUniqueId());
//            registrar.setDisabled(false);
//            registrarService.saveRegistrar(registrar);
//        }
//        else if(users.getRole().equals("teacher")){
//            Teachers teachers = new Teachers();
//            teachers.setUniqueId(users.getUniqueId());
//            teachersService.saveTeacher(teachers);
//        }
//        else if(users.getRole().equals("student")){
//            Students students = new Students();
//            students.setUniqueId(users.getUniqueId());
//            studentsService.saveStudent(students);
//        }
//        usersService.saveUser(users);
//        return "landing.html";
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void deleteUser(@PathVariable("id") Long id){
//        usersService.deleteUserById(id);
//    }
//}
