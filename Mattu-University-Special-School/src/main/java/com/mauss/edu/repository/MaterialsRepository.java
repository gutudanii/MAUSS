package com.mauss.edu.repository;

import com.mauss.edu.model.Materials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialsRepository extends JpaRepository<Materials, Long> {

    List<Materials> getAllMaterialsByClassN(String classN);
}
