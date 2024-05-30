package com.mauss.edu.repository;

import com.mauss.edu.model.Schedules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchedulesRepository extends JpaRepository<Schedules, Long> {
    List<Schedules> getByClassId(String classId);
    List<Schedules> getByTeachId(String teachId);
}
