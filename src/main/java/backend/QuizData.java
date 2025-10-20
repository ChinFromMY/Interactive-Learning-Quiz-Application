/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;
import java.io.*;
import java.util.*;

// Creator: HII SIEW CHIENG (97444)
// Tester: CHAN CHIN XUAN (98439)

// Manage multiple question data for each quiz
public class QuizData {
    
    // Load questions for certain topic
    public static List<Question> loadQuestions(String topic) throws QuizException {
        List<Question> questions = new ArrayList<>();
        String filePath = "quizdata.csv";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Skip header
            reader.readLine(); 

            while ((line = reader.readLine()) != null) {
                String[] parts = splitCSV(line);
                if (parts.length >= 7 && parts[0].equalsIgnoreCase(topic)) {
                    List<String> choices = List.of(parts[4], parts[5], parts[6], parts[7]);
                    // Initialise the question, choices, correct answer to Question class
                    questions.add(new Question(parts[3], choices, parts[8])); 
                }
            }

        } catch (IOException e) {
            throw new QuizException("Failed to load quiz from quiz data file");
        }
        
        return questions;
    }
    
    // Spilt parts for CSV reading
    public static String[] splitCSV(String line) {
        List<String> tokens = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean inQuotes = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '"') {
                inQuotes = !inQuotes;  // toggle quote status
            } else if (c == ',' && !inQuotes) {
                tokens.add(current.toString().trim());
                current.setLength(0);
            } else {
                current.append(c);
            }
        }
        tokens.add(current.toString().trim()); // add last token
        return tokens.toArray(String[]::new);
    }

}
