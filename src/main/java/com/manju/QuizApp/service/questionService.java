package com.manju.QuizApp.service;

import com.manju.QuizApp.model.question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.manju.QuizApp.dao.questionDao;

import java.util.ArrayList;
import java.util.List;


@Service
public class questionService {
    @Autowired
    questionDao questionDao;

    public ResponseEntity<List<question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
    }
    public ResponseEntity<List<question>> getQuestionsByCategory(String category){
        try {

            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);


    }


    public ResponseEntity<String> addQuestion(question question) {
        questionDao.save(question);
        try {
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new String() ,HttpStatus.CREATED);

    }
}
