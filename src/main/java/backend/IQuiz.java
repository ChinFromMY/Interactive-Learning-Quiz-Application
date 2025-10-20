/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package backend;

import java.util.List;

// Creator: CHIN PEI YI (98485)
// Tester: TIONG WOEI CHIN (101224)

// Interface used to implement Quizzes
public interface IQuiz {
    String getTopic();
    List<Question> getQuestion();
    boolean checkAnswer(Question question, String userAnswer);
    int getScore();
}
