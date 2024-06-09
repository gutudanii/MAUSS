package com.mauss.edu.repository;

import com.mauss.edu.model.Registrar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrarRepository extends JpaRepository<Registrar, Long> {
}
