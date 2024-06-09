package com.mauss.edu.quiz;

import com.mauss.edu.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class QuizServiceImpl {

	@Autowired
	QuestionForm qForm;
	@Autowired
	QuizRepository qRepo;
	@Autowired
	Result result;
	@Autowired
	ResultRepo rRepo;

	public QuestionForm getQuestionsByTitle(String title){
		List<Quiz> allQues = qRepo.getAllByTitle(title);
		List<Quiz> qList = new ArrayList<>();

		Random random = new Random();
		int num = allQues.size();
		for(int i=0; i<num; i++) {
			int rand = random.nextInt(allQues.size());
			qList.add(allQues.get(rand));
			allQues.remove(rand);
		}

		qForm.setQuestions(qList);

		return qForm;
	}
	public QuestionForm getQuestions(int num) {
		List<Quiz> allQues = qRepo.findAll();
		List<Quiz> qList = new ArrayList<Quiz>();
		
		Random random = new Random();
		for(int i=0; i<num; i++) {
			int rand = random.nextInt(allQues.size());
			qList.add(allQues.get(rand));
			allQues.remove(rand);
		}

		qForm.setQuestions(qList);
		
		return qForm;
	}
	public int getResult(QuestionForm qForm) {
		int correct = 0;
		
		for(Quiz q: qForm.getQuestions())
			if(q.getAnswer() == q.getChose())
				correct++;
		
		return correct;
	}
	
	public void saveScore(Result result) {
		Result saveResult = new Result();
		saveResult.setUniqueId(result.getUniqueId());
		saveResult.setTotalCorrect(result.getTotalCorrect());
		rRepo.save(saveResult);
	}
	
	public List<Result> getTopScore() {
		List<Result> sList = rRepo.findAll(Sort.by(Sort.Direction.DESC, "totalCorrect"));
		return sList;
	}
}
