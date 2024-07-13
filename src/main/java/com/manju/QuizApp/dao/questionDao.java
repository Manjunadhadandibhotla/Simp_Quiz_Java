package com.manju.QuizApp.dao;
import com.manju.QuizApp.model.question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface questionDao extends JpaRepository<question,Integer> {
    List<question> findByCategory( String category);
    @Query(value = "SELECT * FROM question q Where q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<question> findRandomQuestionsByCategory(String category, int numQ);

}
