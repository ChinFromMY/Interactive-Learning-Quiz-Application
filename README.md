**Deepfake Interactive Learning Quiz Application
**
The Deepfake Interactive Learning Quiz Application is a Java-based desktop application designed to raise awareness about the Deepfake technologies, creation techniques and the consequnces of misused that can contributed to real world problem. It having learning modules that combined with enaging timed quizzes to test user comprehension.

Key Features:
Interactive Learning Modules: 
-Provides educational content about deepfake technology.

Various quiz types:
- Fill in the blanks quiz
- True/False Quiz
- Multiple Choice Quiz (MCQ)
- Matching Quiz

Timed Quizzes and Scoring:
- Utilizes a TimerManager to track the time taken for each quiz then displaying it in the panel

User Persistence:
- Includes dedicated Login and Sign-Up panels to manage user accounts and progress.
 
Result Logging:
- Upon completion, the application logs the user's score, time taken, correct and wrong answer counts using ResultLog.saveResult().

Custom GUI:
- Built with Java Swing components to manage the screen transitions using CardLayout.

How to run:
cd path/to/DeepfakeAwareness
java -cp target\classes main.DeepfakeAwareness

