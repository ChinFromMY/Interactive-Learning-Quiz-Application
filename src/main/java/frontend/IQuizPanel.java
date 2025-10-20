/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package frontend;

// Creator: HII SIEW CHIENG (97444)
// Tester: CHAN CHIN XUAN (98439)

// Interface used to implement quiz panels
public interface IQuizPanel {
    void displayQuestion();
    void startTimer();
    void updateTimerLabel(long seconds);
    void stopTimer();
    void resetQuiz();
}
