package com.mauss.edu.repository;

import com.mauss.edu.model.Academic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AcademicRepository extends JpaRepository<Academic, Long> {

    Optional<Academic> getByAcademicId(String academicId);
    List<Academic> getByEnd(boolean end);
}
