package com.mauss.edu.quiz;

import com.mauss.edu.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    @Autowired
    QuizRepository qRepo;

    public Quiz questionsSet(Quiz questions){
        return qRepo.save(questions);
    }
}
