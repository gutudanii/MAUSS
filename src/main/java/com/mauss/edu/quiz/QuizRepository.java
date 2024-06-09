package com.mauss.edu.quiz;

import com.mauss.edu.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

    List<Quiz> getAllByAuthorId(String authorId);
    Optional<Quiz> findByAuthorId(String authorId);
    List<Quiz> getAllByTitle(String title);
}
