package com.mauss.edu.controller;

import com.mauss.edu.model.Administrators;
import com.mauss.edu.model.Announcement;
import com.mauss.edu.model.Users;
import com.mauss.edu.repository.AnnouncementRepository;
import com.mauss.edu.repository.UsersRepository;
import com.mauss.edu.service.AnnouncementService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class AnnouncementController {

    @Autowired
    private final AnnouncementService announcementService;
    @Autowired
    private final AnnouncementRepository announcementRepository;
    @Autowired
    private final UsersRepository usersRepository;
    @PostMapping("/announcement/save")
    public String saveAnnounce(@ModelAttribute Announcement announcement,
                               Principal principal, @RequestParam("image")MultipartFile multipartFile) throws IOException {
        Users users = usersRepository.findByUsername(principal.getName()).get();

        announcement.setAuthorId(users.getUniqueId());
        announcement.setFileName(multipartFile.getOriginalFilename());

        announcement.setImage(multipartFile.getBytes());
        announcementService.saveAnnouncement(announcement);
        return "redirect:/dashboard";
    }
    @RequestMapping(path = {"/delete/announcement", "/delete/announcement/{id}"})
    public String deleteBId(@PathVariable("id")Long id){
        announcementService.deleteAnnouncement(id);
        return "redirect:/dashboard";
    }
    @GetMapping("/announcement/update/{id}")
    public String getPage(Model model, @PathVariable("id")Long id){
        Announcement announcement1 = announcementRepository.findById(id).get();
        model.addAttribute("announcement", announcement1);
        return "/updateAnnouncement.html";
    }
    @PostMapping("{id}/save/update")
    public String saveUpdate(@ModelAttribute Announcement announcement, @PathVariable("id") Long id){
        announcementService.updateAnnouncement(announcement, id);
        return "redirect:/dashboard";
    }
    @GetMapping("/announcement/image/{id}")
    public ResponseEntity<byte[]> viewImage(@PathVariable Long id) {
        Optional<Announcement> imageEntityOptional = announcementRepository.findById(id);
        if (imageEntityOptional.isPresent()) {
            Announcement imageEntity = imageEntityOptional.get();
            HttpHeaders headers = new HttpHeaders();
            String fileName = imageEntity.getFileName();

            String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
            switch (fileExtension){
                case "jpeg", "jpg":
                    headers.setContentType(MediaType.IMAGE_JPEG);
                    break;
                case "png":
                    headers.setContentType(MediaType.IMAGE_PNG);
                    break;
                default:
                    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            }

            return new ResponseEntity<>(imageEntity.getImage(), headers, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
