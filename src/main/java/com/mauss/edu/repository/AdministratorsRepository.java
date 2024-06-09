package com.mauss.edu.repository;

import com.mauss.edu.model.Administrators;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorsRepository extends JpaRepository<Administrators, Long> {
}
