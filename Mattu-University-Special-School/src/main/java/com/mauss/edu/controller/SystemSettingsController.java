package com.mauss.edu.controller;

import com.mauss.edu.model.Administrators;
import com.mauss.edu.model.SystemSetting;
import com.mauss.edu.repository.SystemSettingRepository;
import com.mauss.edu.service.SystemSettingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class SystemSettingsController {

    @Autowired
    private final SystemSettingService systemSettingService;

    @Autowired
    private final SystemSettingRepository systemSettingRepository;

    @PostMapping("/system/save")
    public String saveSystem(@ModelAttribute SystemSetting systemSetting, @RequestParam("logo") MultipartFile logo) throws IOException {
        if (!logo.isEmpty()) {
            systemSetting.setLogo(logo.getBytes());
            systemSetting.setFileName(logo.getOriginalFilename());
        }
        systemSettingService.saveSystemSettings(systemSetting);
        return "redirect:/dashboard";
    }
    @DeleteMapping("/sys/delete/{id}")
    public String deleteSys(@PathVariable("id")Long id){
        systemSettingService.deleteSys(id);
        return "redirect:/dashboard";
    }
    @GetMapping("/system/image/{id}")
    public ResponseEntity<byte[]> viewImage(@PathVariable Long id) {
        Optional<SystemSetting> imageEntityOptional = systemSettingRepository.findById(id);
        if (imageEntityOptional.isPresent()) {
            SystemSetting imageEntity = imageEntityOptional.get();
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

            return new ResponseEntity<>(imageEntity.getLogo(), headers, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
