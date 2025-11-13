#Deepfake Interactive Learning Quiz Application
_____________________________________________________________________________________

The Deepfake Interactive Learning Quiz Application is a Java-based desktop application designed to raise awareness about deepfake technology, its creation techniques and the potential consequences of misuse.
This application combines interactive learning modules with timed quizzes to help users understand and evaluate their knowledge of deepfakes in an engaging way. 
_____________________________________________________________________________________

##Key Features
Interactive Learning Modules
-Provides educational content about deepfake technology and its real-world implications.

Multiple Quiz Types
- Fill-in-the-Blank Quiz
- True/False Quiz
- Multiple Choice Quiz (MCQ)
- Matching Quiz

Timed Quizzes and Scoring
- Uses a TimerManager to track the time taken for each quiz and display it dynamically within the interface.

User Account Management
- Includes dedicated Login and Sign-Up panels to manage user profiles and tracking progress.

Leaderboard System
- Display top-performing users based on quiz scores and completion times.
- Encourages engagement and healthy competition among users.
 
Result Logging
- After completing a quiz, results (including score, time taken and correct/wrong answers) are recorded using ResultLog.saveResult().

Custom GUI
- Developed using Java Swing, using CardLayout to manage transitions between modules, quizzes and results screens. 

##How to run
cd path/to/DeepfakeAwareness
java -cp target\classes main.DeepfakeAwareness

