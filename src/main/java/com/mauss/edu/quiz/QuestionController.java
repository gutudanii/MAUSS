package com.mauss.edu.quiz;

import com.mauss.edu.model.Classes;
import com.mauss.edu.model.Courses;
import com.mauss.edu.model.Quiz;
import com.mauss.edu.repository.ClassesRepository;
import com.mauss.edu.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.Principal;
import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    QuizPrepare quizPrepare;
    @Autowired
    QuizRepository questionRepository;

    @Autowired
    CoursesRepository coursesRepository;

    @Autowired
    ClassesRepository classesRepository;

    @PostMapping("/quiz/save")
    public String save(@ModelAttribute @RequestBody Quiz questions, Model model, Principal principal){
        quizPrepare.SaveQuestionsCreated(questions, principal);
        model.addAttribute("question1", questions);
        List<Courses> getAllCourse = coursesRepository.findAll();
        model.addAttribute("courseList", getAllCourse);

        List<Classes> getAllClasses = classesRepository.findAll();
        model.addAttribute("classList", getAllClasses);

        model.addAttribute("numb", 1);
        return "/quiz/question.html";
    }

    @GetMapping("/quiz/question")
    public String getQuestions(Model model){
        Quiz questions = new Quiz();
        List<Courses> getAllCourse = coursesRepository.findAll();
        model.addAttribute("courseList", getAllCourse);

        List<Classes> getAllClasses = classesRepository.findAll();
        model.addAttribute("classList", getAllClasses);

        model.addAttribute("question1", questions);
        return "/quiz/question.html";
    }

    @GetMapping("/quiz/completed")
    public String getCompletionPage(){
        return "redirect:/dashboard";
    }
}
