/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;
import java.util.List;
import javax.swing.JOptionPane;

// Creator: HII SIEW CHIENG (97444)
// Tester: CHAN CHIN XUAN (98439)

// Quiz Manager for Topic 4
// Multiple Choices Quiz
public class Quiz4 implements IQuiz {
    private final String topic = "4";
    private List<Question> questionList;
    private int score = 0;
    private long timeTaken;
    private int correctCnt;
    private int wrongCnt;
    
    public void setScore(int score) {
        this.score = score;
    }
    
    public void setTimeTaken(long seconds) {
        this.timeTaken = seconds;
    }
    public long getTimeTaken() {
        return timeTaken;
    }
    public int getCorrectCnt() {
        return correctCnt;
    }
    
    public int getWrongCnt() {
        return wrongCnt;
    }
   
    // Constructor
    public Quiz4() throws QuizException{
        try {
            // Load questions for topic1 
            this.questionList = QuizData.loadQuestions(topic);
        } catch (QuizException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    // === Overriden methods from IQuiz interface ===
    @Override
    public String getTopic() {
        return topic;
    }

    @Override
    public List<Question> getQuestion() {
        return questionList;
    }

    @Override
    public boolean checkAnswer(Question question, String userAnswer) {
        // Checking
        boolean ansIsCorrect;
        ansIsCorrect = question.getCorrectAns().equalsIgnoreCase(userAnswer);
        
        // Update score
        if (ansIsCorrect) {
            score += 10;
            this.correctCnt++;
        } else { 
            this.wrongCnt++;
        }
        return ansIsCorrect;
    }
    
    
    @Override
    public int getScore() {
        return score;
    }
    
}
