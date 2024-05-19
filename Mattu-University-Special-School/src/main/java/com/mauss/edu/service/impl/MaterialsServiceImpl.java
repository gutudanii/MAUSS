package com.mauss.edu.service.impl;

import com.mauss.edu.model.Materials;
import com.mauss.edu.repository.MaterialsRepository;
import com.mauss.edu.service.MaterialsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class MaterialsServiceImpl implements MaterialsService {

    @Autowired
    private final MaterialsRepository materialsRepository;

    @Override
    public Optional<Materials> findById(Long id) {
        return materialsRepository.findById(id);
    }
    @Override
    public void saveMaterials(Materials materials) {
        String id = autoIdGenerator();
        materials.setMaterialId(id);
        materialsRepository.save(materials);
    }


    @Override
    public void deleteMaterials(Long id) {

    }

    @Override
    public List<Materials> getAllMaterials() {
        return materialsRepository.findAll();
    }

    @Override
    public void editMaterials(Long id, Materials materials) {
        Materials materials1 = materialsRepository.findById(id).get();

            materials1.setMaterialId(materials.getMaterialId());
            materials1.setTeachId(materials.getTeachId());
            materials1.setClassId(materials.getClassId());
            materials1.setClassN(materials1.getClassN());
            materials1.setCourseId(materials.getCourseId());
            materials1.setCourseN(materials.getCourseN());
            materials1.setTitle(materials.getTitle());
            materials1.setDescription(materials.getDescription());
            materials1.setActivate(materials.isActivate());
            materials1.setMaterial(materials.getMaterial());
            materialsRepository.save(materials1);
    }

    @Override
    public Optional<Materials> getMaterialByID(Long id) {
        return materialsRepository.findById(id);
    }

    String autoIdGenerator(){
        Random random = new Random();
        int count = materialsRepository.findAll().size();
        String id = "CRS-"+ count + random.nextInt(0,100) ;
        return id;
    }
}
