package com.mauss.edu.quiz;

import com.mauss.edu.model.Quiz;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public interface QuizPrepareService {

    void SaveQuestionsCreated(Quiz questionEntity, Principal principal);
}
