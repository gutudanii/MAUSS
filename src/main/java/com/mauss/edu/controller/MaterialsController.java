package com.mauss.edu.controller;

import com.mauss.edu.model.Materials;
import com.mauss.edu.model.Users;
import com.mauss.edu.repository.UsersRepository;
import com.mauss.edu.service.MaterialsService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class MaterialsController {

    @Autowired
    private final MaterialsService materialsService;
    @Autowired
    private final UsersRepository usersRepository;
    @PostMapping("/materials/save")
    public String saveMaterials(@ModelAttribute Materials materials, @RequestParam("material") MultipartFile material, Principal principal) throws IOException {
        if (!material.isEmpty()) {
            materials.setMaterial(material.getBytes());
            materials.setFileName(material.getOriginalFilename());
        }
        Users users = usersRepository.findByUsername(principal.getName()).get();
        materials.setTeachId(users.getUniqueId());
        materials.setActivate(true);
        materialsService.saveMaterials(materials);
        return "redirect:/dashboard";
    }

    @GetMapping("/materials/update/{id}")
    public String getMatUpdate(@PathVariable Long id, Model model) {
        Materials materials = materialsService.getMaterialByID(id).get();
        model.addAttribute("material", materials);
        return "updateMaterial";
    }
    @PostMapping("/{id}/edit/materials")
    public String getDash(@PathVariable("id") Long id, @ModelAttribute("material") Materials materials) {
        materialsService.editMaterials(id, materials);
        return "redirect:/dashboard";
    }
    @RequestMapping(path = {"/material/disable", "/material/disable/{id}"})
    public String disable(@PathVariable("id") Long id){
        materialsService.disable(id);
        return "redirect:/dashboard";
    }
    @RequestMapping(path = {"/material/delete", "/material/delete/{id}"})
    public String delete(@PathVariable("id") Long id){
        materialsService.deleteMaterials(id);
        return "redirect:/dashboard";
    }
    @RequestMapping(path = {"/material/enable", "/material/enable/{id}"})
    public String enable(@PathVariable("id") Long id){
        materialsService.enable(id);
        return "redirect:/dashboard";
    }
    @GetMapping("/materials/{id}/download")
    public ResponseEntity<byte[]> downloadMaterial(@PathVariable Long id) {
        Optional<Materials> materialOptional = materialsService.findById(id);
        if (materialOptional.isPresent()) {
            Materials material = materialOptional.get();
            byte[] fileBytes = material.getMaterial(); // Assuming getMaterial() returns byte array of the file
            String fileName1 = material.getTitle(); // Assuming getFileName() returns the filename
            String fileName = material.getFileName(); // Assuming getFileName() returns the filename

            HttpHeaders headers = new HttpHeaders();

            // Set content type based on file extension
            String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
//            System.out.println("File extension: " + fileExtension); // Add this line for debugging
            switch (fileExtension) {
                case "pdf":
                    headers.setContentType(MediaType.APPLICATION_PDF);
                    break;
                case "pptx":
                    headers.setContentType(new MediaType("application", "vnd.openxmlformats-officedocument.presentationml.presentation"));
                    break;
                case "doc":
                    headers.setContentType(new MediaType("application", "msword"));
                    break;
                case "docx":
                    headers.setContentType(new MediaType("application", "vnd.openxmlformats-officedocument.wordprocessingml.document"));
                    break;
                default:
                    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM); // Fallback to generic binary data
            }

            // Set filename in content disposition including file extension
            headers.setContentDisposition(ContentDisposition.builder("attachment").filename(fileName).build());

            return new ResponseEntity<>(fileBytes, headers, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}