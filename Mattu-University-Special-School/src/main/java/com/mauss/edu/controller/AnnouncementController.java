package com.mauss.edu.controller;

import com.mauss.edu.model.Announcement;
import com.mauss.edu.service.AnnouncementService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AnnouncementController {

    @Autowired
    private final AnnouncementService announcementService;

    @PostMapping("/announcement/save")
    public String saveAnnounce(@ModelAttribute Announcement announcement){
        announcementService.saveAnnouncement(announcement);
        return "redirect:/dashboard";
    }


}
