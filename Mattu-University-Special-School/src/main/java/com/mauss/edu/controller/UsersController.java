package com.mauss.edu.controller;

import com.mauss.edu.model.*;
import com.mauss.edu.repository.*;
import com.mauss.edu.service.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    private final AnnouncementRepository announcementRepository;
    @Autowired
    private final DepartmentsService departmentsService;
    @Autowired
    private final TeachersService teachersService;
    @Autowired
    private final StudentsService studentsService;
    @Autowired
    private final AdministratorsRepository administratorsRepository;
    @Autowired
    private final AcademicRepository academicRepository;
    @Autowired
    private final MaterialsRepository materialsRepository;
    @Autowired
    private final DepartmentsRepository departmentsRepository;
    @Autowired
    private final StudentsRepository studentsRepository;
    @Autowired
    private final SchedulesRepository schedulesRepository;

    @GetMapping("/users/all")
    @ResponseBody
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping("/")
    public String ger(Principal principal, Model model){
        List<Administrators> getAllAdministrators = administratorsRepository.findAll();
        if (principal != null){
            model.addAttribute("administrator", getAllAdministrators);
            return "redirect:/home";
        }
        model.addAttribute("administrator", getAllAdministrators);
        return "landing.html";
    }
    @GetMapping("/users/update/{uniqueId}")
    public String getUsersUpdate(@PathVariable String uniqueId, Model model){
        Users users = usersRepository.findByUniqueId(uniqueId).get();
        model.addAttribute("usersUpdate", users);
        return "/userUpdate.html";
    }
    @PostMapping("/{uniqueId}/edit/users")
    public String saveUsers(@PathVariable("uniqueId")String uniqueId, @ModelAttribute Users users){
        usersService.updateUser(uniqueId, users);
        return "redirect:/dashboard";
    }
    @GetMapping("/users/login")
    public String getUsersHtml(){
        return "redirect:/";
    }
    @GetMapping("/home")
    public String getHome(Model model){
        List<Administrators> getAllAdministrators = administratorsRepository.findAll();
        model.addAttribute("administrator", getAllAdministrators);
        return "home.html";
    }
    @GetMapping("/dashboard")
    public String getPage(Principal principal, Users users, Model model){
        Users users1 = usersRepository.findByUsername(principal.getName()).get();
        if (users1.getRole().equals("student")){
            model.addAttribute("usrFName", users1.getFName());
            List<Materials> getAllMaterials  = materialsService.getAllMaterials();
            model.addAttribute("materials", getAllMaterials);
            Students students = studentsRepository.findByUniqueId(users1.getUniqueId()).get();
            String grd = String.valueOf(students.getGrade());
            List<String> getTargets = Arrays.asList("all", "student", grd);
            List<Announcement> getAnnouncementByRole = announcementRepository.findByTargetIn(getTargets);
            model.addAttribute("getAnn", getAnnouncementByRole);
            return "/student.html";
        }
        else if (users1.getRole().equals("teacher")){
            Materials material = new Materials();
            model.addAttribute("materials", material);
            model.addAttribute("materialList", materialsRepository.getAllByTeachId(users1.getUniqueId()));
            if (departmentsRepository.getByUniqueId(users1.getUniqueId()).isPresent() && !departmentsRepository.getByUniqueId(users1.getUniqueId()).get().isDisabled()) {
                model.addAttribute("viewDep", true );
            }
            Announcement announcement = new Announcement();
            model.addAttribute("announcement", announcement);
            List<Announcement> getAllByAuthorId = announcementRepository.getAllByAuthorId(users1.getUniqueId());
            model.addAttribute("getAnn", getAllByAuthorId);
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

            List<Departments> getAllByStreamDepNat = new ArrayList<>();
            List<Departments> getAllByStreamDepSoc = new ArrayList<>();

            List<Departments> getAllNotDisabledDepartment = departmentsRepository.getAllByDisabled(false);
            for(int i=0; i<getAllNotDisabledDepartment.size(); i++){
                if (getAllNotDisabledDepartment.get(i).getStream().equals("Natural")){
                    getAllByStreamDepNat.add(getAllNotDisabledDepartment.get(i));
                }
                else{
                    getAllByStreamDepSoc.add(getAllNotDisabledDepartment.get(i));
                }
            }
            model.addAttribute("naturalDep", getAllByStreamDepNat);
            model.addAttribute("socialDep", getAllByStreamDepSoc);
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
            Administrators administrators = new Administrators();
            model.addAttribute("administrator", administrators);
            List<Administrators> getAllAdministrators = administratorsRepository.findAll();
            model.addAttribute("getAdministrator", getAllAdministrators);
            Announcement announcement = new Announcement();
            model.addAttribute("announcement", announcement);
            List<Announcement> getAllByAuthorId = announcementRepository.getAllByAuthorId(users1.getUniqueId());
            model.addAttribute("getAnn", getAllByAuthorId);
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
    @GetMapping("/department")
    public String getDepartment(Principal principal, Model model){
        Users users = usersRepository.findByUsername(principal.getName()).get();
        if (departmentsRepository.getByUniqueId(users.getUniqueId()).isPresent() &&
                !departmentsRepository.getByUniqueId(users.getUniqueId()).get().isDisabled()){
            Departments departments = departmentsRepository.getByUniqueId(users.getUniqueId()).get();
            List<Users> getAllStudents = usersRepository.findAllUsersByRole("student");

            Schedules schedules = new Schedules();

            if(departments.getStream().equals("Natural")){
                model.addAttribute("studentUser", getAllStudents);
                model.addAttribute("schedule", schedules);

                List<Academic> getAllAcademic = academicRepository.getByEnd(false);
                model.addAttribute("academics", getAllAcademic);

                List<Classes> getAllClasses = classesRepository.getByEnd(false);
                model.addAttribute("classes", getAllClasses);

                List<Courses> getAllCourses = coursesRepository.findAll();
                model.addAttribute("courses", getAllCourses);

                List<Users> getAllTeacher = usersRepository.findAllUsersByRole("teacher");
                model.addAttribute("teachers", getAllTeacher);
//
//                List<Schedules> listSchedules = schedulesRepository.findAll();
//
//                // Generate a list of schedule hours
//                List<String> scheduleHours = Stream.of("08:00 - 09:00", "09:00 - 10:00", "10:00 - 11:00", "11:00 - 12:00",
//                                "13:00 - 14:00", "14:00 - 15:00", "15:00 - 16:00")
//                        .collect(Collectors.toList());
//
//                model.addAttribute("schedules", listSchedules);
//                model.addAttribute("scheduleHours", scheduleHours);


                return "/departmentNatural.html";
            }
            else {
                model.addAttribute("studentUser", getAllStudents);
                model.addAttribute("schedule", schedules);
                return "/departmentSocial.html";
            }
        }
        else {
            return "redirect:/dashboard";
        }
    }
}