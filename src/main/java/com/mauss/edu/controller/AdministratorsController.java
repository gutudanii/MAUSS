package com.mauss.edu.controller;

import com.mauss.edu.model.Administrators;
import com.mauss.edu.repository.AdministratorsRepository;
import com.mauss.edu.service.AdministratorsService;
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
public class AdministratorsController {

    @Autowired
    private final AdministratorsService administratorsService;

    @Autowired
    private final AdministratorsRepository administratorsRepository;
    @PostMapping("/administrators/save")
    public String saveAdministrators(@ModelAttribute Administrators administrators, @RequestParam("image")MultipartFile image) throws IOException {
        if (!image.isEmpty()){
            administrators.setImage(image.getBytes());
            administrators.setFileName(image.getOriginalFilename());
        }
        administratorsService.saveAdministrators(administrators);
        return "redirect:/dashboard";
    }
    @RequestMapping(path = {"/admins/delete","/admins/delete/{id}"})
    public String deleteAdmins(@PathVariable("id")Long id){
        administratorsService.deleteAdmns(id);
        return "redirect:/dashboard";
    }
    @GetMapping("/admins/image/{id}")
    public ResponseEntity<byte[]> viewImage(@PathVariable Long id) {
        Optional<Administrators> imageEntityOptional = administratorsRepository.findById(id);
        if (imageEntityOptional.isPresent()) {
            Administrators imageEntity = imageEntityOptional.get();
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
