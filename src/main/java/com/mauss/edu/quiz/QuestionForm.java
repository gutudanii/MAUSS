package com.mauss.edu.quiz;

import com.mauss.edu.model.Quiz;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionForm {

    private List<Quiz> questions;

    public List<Quiz> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Quiz> questions) {
        this.questions = questions;
    }

}
