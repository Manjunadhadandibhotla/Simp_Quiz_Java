package com.manju.QuizApp.dao;

import com.manju.QuizApp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz, Integer> {



}
