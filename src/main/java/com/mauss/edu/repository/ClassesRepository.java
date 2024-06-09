package com.mauss.edu.repository;

import com.mauss.edu.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClassesRepository extends JpaRepository<Classes, Long> {

    List<Classes> getAllByAcaId(String acaId);
    List<Classes> getAllByClassId(String classId);
    Optional<Classes> getByAcaId(String acaId);
    List<Classes> getByEnd(boolean end);
}
