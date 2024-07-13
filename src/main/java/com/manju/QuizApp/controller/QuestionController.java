package com.manju.QuizApp.controller;

import com.manju.QuizApp.model.question;
import com.manju.QuizApp.service.questionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    questionService questionService ;

    @GetMapping("allQuestions")
    public ResponseEntity<List<question>> getAllQuestions(){
        return questionService.getAllQuestions() ;

    }
    @GetMapping("category/{category}")
    public ResponseEntity<List<question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody question question){
        return  questionService.addQuestion(question);
    }

}
