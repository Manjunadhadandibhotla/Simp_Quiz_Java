package com.manju.QuizApp.controller;
import com.manju.QuizApp.model.QuestionWrapper;
import com.manju.QuizApp.model.question;
import com.manju.QuizApp.service.QuizService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.processing.SupportedAnnotationTypes;
import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category ,@RequestParam int numQ,@RequestParam String title){
        return quizService.createQuiz(category, numQ, title);

    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }


}
