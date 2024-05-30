package com.mauss.edu.quiz;

import com.mauss.edu.model.Quiz;
import com.mauss.edu.model.Users;
import com.mauss.edu.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
public class MainController {
	
	@Autowired
	Result result;

	@Autowired
	UsersRepository userRepository;
	@Autowired
	QuizServiceImpl qService;

	@Autowired
	QuizRepository qRepo;
	Boolean submitted = false;
	
	@ModelAttribute("result")
	public Result getResult() {
		return result;
	}
	@GetMapping("/home/quiz")
	public String home() {
		return "quiz/index.html";
	}

	@PostMapping("/quiz/quiz")
	public String quiz(
			@RequestParam("title")String title,
			Model m, RedirectAttributes ra, Principal principal) {
		Users users1 = userRepository.findByUsername(principal.getName()).get();
			 submitted = false;
			result.setUniqueId(users1.getUniqueId());
//			int num = 0;
//          List<Quiz> allQues = qRepo.findAll();
//          int numb = allQues.size();
          QuestionForm qForm = qService.getQuestionsByTitle(title);
          m.addAttribute("qForm", qForm);
		return "quiz/quiz.html";
	}
	
	@PostMapping("/quiz/submit")
	public String submit(@ModelAttribute QuestionForm qForm, Model m) {
		if(!submitted) {
			result.setTotalCorrect(qService.getResult(qForm));
			qService.saveScore(result);
			submitted = true;
		}
		List<Quiz> questions = qRepo.findAll();
		m.addAttribute("num",questions.size());
		return "quiz/result.html";
	}
	
	@GetMapping("/quiz/score")
	public String score(Model m) {
		List<Result> sList = qService.getTopScore();
		m.addAttribute("sList", sList);
		
		return "quiz/scoreboard.html";
	}

}
