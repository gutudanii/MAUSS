package com.mauss.edu.quiz;

import com.mauss.edu.model.Quiz;
import com.mauss.edu.model.Users;
import com.mauss.edu.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Random;

@Service
public class QuizPrepare implements QuizPrepareService {


    @Autowired
    QuizRepository questionRepo;

    @Autowired
    UsersRepository userRepository;

    @Override
    public void SaveQuestionsCreated(Quiz questions, Principal principal) {

        Random random = new Random();

        //TODO: Set Questions
        questions.setChose(-1);

        //TODO:Save EntityQuestions
        Users users = userRepository.findByUsername(principal.getName()).get();
        questions.setAuthorId(users.getUniqueId());

//        //TODO: UUID
//        String uuid = UUID.randomUUID().toString();
//        questions.setTokenId(uuid);

//        //TODO: Custom Id
//        String fName = "QUIZ-";
//        String name = users.getFirstName().substring(0,2).toUpperCase();
//        int num = random.nextInt(0,1000);
//        questions.setCustomId(fName+name+num);
        //TODO:SAVES
        questionRepo.save(questions);
    }
}
