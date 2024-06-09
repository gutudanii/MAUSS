package com.mauss.edu.repository;

import com.mauss.edu.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String username);
    Optional<Users> findByUniqueId(String uniqueId);
    List<Users> findAllUsersByRole(String role);

}
