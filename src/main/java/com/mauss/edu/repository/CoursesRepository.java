package com.mauss.edu.repository;

import com.mauss.edu.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Long> {

    List<Courses> getAllByTargetGrade(String targetGrade);

}
