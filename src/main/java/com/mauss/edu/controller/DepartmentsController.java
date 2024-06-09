package com.mauss.edu.controller;

import com.mauss.edu.model.Departments;
import com.mauss.edu.model.Materials;
import com.mauss.edu.model.Users;
import com.mauss.edu.repository.DepartmentsRepository;
import com.mauss.edu.repository.UsersRepository;
import com.mauss.edu.service.DepartmentsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
public class DepartmentsController {

    @Autowired
    private final DepartmentsService departmentsService;
    @Autowired
    private final UsersRepository usersRepository;
    @Autowired
    private final DepartmentsRepository departmentsRepository;
    @PostMapping("department/save")
    public String saveDepartment(@ModelAttribute Departments departments, Principal principal){
        Users users = usersRepository.findByUniqueId(departments.getUniqueId()).get();
        Users users1 = usersRepository.findByUsername(principal.getName()).get();
        departments.setTeachName(users.getFName() + " " + users.getMName() + " " + users.getLName());
        departments.setAssignedRegId(users1.getUniqueId());
        departments.setDisabled(false);
        departments.setRevoked(false);

        if (departmentsRepository.getAllByDisabled(false).size() < 2 ){
            departmentsService.saveDepartment(departments);
        }
        return "redirect:/dashboard";
    }

    @RequestMapping(path = {"/disable/department", "/disable/department/{id}"})
    public String disable(@PathVariable("id") Long id) {
        departmentsService.disable(id);
        return "redirect:/dashboard";
    }
}
