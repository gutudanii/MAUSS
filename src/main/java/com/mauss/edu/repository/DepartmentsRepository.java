package com.mauss.edu.repository;

import com.mauss.edu.model.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentsRepository extends JpaRepository<Departments, Long> {
    Optional<Departments> getByUniqueId(String uniqueId);
    List<Departments> getAllByStream(String stream);
    Optional<Departments> getByStream(String stream);
    List<Departments> getAllByDisabled(boolean disabled);
}
