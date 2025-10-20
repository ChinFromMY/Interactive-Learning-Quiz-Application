/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;
import java.util.List;

// Creator: HII SIEW CHIENG (97444)
// Tester: CHAN CHIN XUAN (98439)

// Represent a single question data item
public class Question {
    private final String questionText;
    private final List<String> choices;
    private final String correctAns;
    
    public Question(String questionText, List<String> choices, String correctAns) {
        this.questionText = questionText;
        this.choices = choices;
        this.correctAns = correctAns;
    }
    
     public String getQuestionText() {
        return questionText;
    }

    public List<String> getChoices() {
        return choices;
    }

    public String getCorrectAns() {
        return correctAns;
    }
    
      
}
