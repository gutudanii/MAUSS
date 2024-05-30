package com.mauss.edu.controller;

import com.mauss.edu.mail.MailService;
import com.mauss.edu.model.Contact;
import com.mauss.edu.model.Courses;
import com.mauss.edu.model.Schedules;
import com.mauss.edu.model.Users;
import com.mauss.edu.repository.CoursesRepository;
import com.mauss.edu.repository.SchedulesRepository;
import com.mauss.edu.repository.UsersRepository;
import com.mauss.edu.service.ContactService;
import com.mauss.edu.service.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@AllArgsConstructor
public class ScheduleController {

    @Autowired
    private final ScheduleService scheduleService;
    @Autowired
    private final MailService mailService;
    @Autowired
    private final CoursesRepository coursesRepository;
    @Autowired
    private final UsersRepository usersRepository;
    @Autowired
    private final ContactService contactService;
    @Autowired
    private final SchedulesRepository schedulesRepository;
    @PostMapping("/schedules/save")
    public String Schedule(@ModelAttribute Schedules schedules, Principal principal){
        Users us = usersRepository.findByUsername(principal.getName()).get();
        schedules.setSchedulerId(us.getUniqueId());
        Users users = usersRepository.findByUniqueId(schedules.getTeachId()).get();
        schedules.setTeachName(users.getFName() +" " +users.getMName()+ " " + users.getLName());
        Long crsId = (long) Integer.parseInt(schedules.getCourseId());
        Courses courses = coursesRepository.findById(crsId).get();
        schedules.setCourseName(courses.getCourseName() + " " + courses.getCourseCode());
        scheduleService.saveSchedule(schedules);
        return "redirect:/department";
    }

    @GetMapping("/schedules/view/{classId}")
    public String getSchedule(@PathVariable("classId")String classId, Model model){

        List<Schedules> listSchedules = schedulesRepository.getByClassId(classId);

        // Generate a list of schedule hours
        List<String> scheduleHours = Stream.of("08:00 - 09:00", "09:00 - 10:00", "10:00 - 11:00", "11:00 - 12:00",
                        "13:00 - 14:00", "14:00 - 15:00", "15:00 - 16:00")
                .collect(Collectors.toList());

        model.addAttribute("schedules", listSchedules);
        model.addAttribute("scheduleHours", scheduleHours);

        return "/viewSchedule.html";
    }

    @PostMapping("/contact/save")
    public String getContact(@ModelAttribute Contact contact){
        contactService.saveContact(contact);
        return "redirect:/";
    }

}