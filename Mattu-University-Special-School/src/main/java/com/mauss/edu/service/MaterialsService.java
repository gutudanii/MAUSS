package com.mauss.edu.service;

import com.mauss.edu.model.Materials;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MaterialsService {

    Optional<Materials> findById(Long id);
    void saveMaterials(Materials materials);
    void deleteMaterials(Long id);
    List<Materials> getAllMaterials();
    void editMaterials(Long id, Materials materials);
    Optional<Materials> getMaterialByID(Long id);
}
