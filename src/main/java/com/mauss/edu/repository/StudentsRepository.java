package com.mauss.edu.repository;

import com.mauss.edu.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Long> {

    Optional<Students> findByUniqueId(String uniqueId);
    List<Students> getByClassId(String classId);

}
