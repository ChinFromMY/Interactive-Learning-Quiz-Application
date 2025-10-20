/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.table.DefaultTableModel;

// Creator: HII SIEW CHIENG (97444)
// Tester: CHAN CHIN XUAN (98439)

// To store quiz results from all user
public class ResultLog {
    private static final String FILENAME = "quiz_log.csv";
    
    // Save quiz result into CSV after quiz ends
    public static void saveResult(int topic, int score, long timeTaken, int correctCnt, int wrongCnt) throws ResultException {
        String username = UserData.getUsername();
        
        if (username.isEmpty()) {
            System.err.println("No username provided. Result cannot be saved!");
            return;
        }
        
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        
        String record = String.join(",",
                username,
                String.valueOf(topic),
                String.valueOf(score),
                String.valueOf(timeTaken),
                String.valueOf(correctCnt),
                String.valueOf(wrongCnt),
                dateTime
        ) + "\n";
        
        File file = new File(FILENAME);
        boolean fileExists;
        fileExists = file.exists();
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME,true))){
            
            // Write column names (header)
            if (!fileExists) {
                writer.write("Username,Topic,Score,TimeTaken,Correct,Wrong,DateTime");
                writer.newLine();
            }
            
            writer.write(record);
            writer.close();
            
        } catch (IOException e) {
            throw new ResultException("Failed to save result for user '" + username + "'.", e);
        }
         
    }
    
    // Overload 1: Get user quiz attempts for specific topic
    public static DefaultTableModel loadResults(String username, String topicFilter) throws ResultException{
        DefaultTableModel table = new DefaultTableModel(new String[]{
            "DateTime", "Topic", "Score", "Time taken", "Correct", "Wrong"}, 0);

        DateTimeFormatter[] inputFormats = new DateTimeFormatter[]{
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"),
            DateTimeFormatter.ofPattern("M/d/yyyy h:mm:ss a", Locale.ENGLISH),
            DateTimeFormatter.ofPattern("M/d/yyyy H:mm"),
            DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")
        };
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");

        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String line; // Skip header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 7 && values[0].equals(username)) {
                    if (topicFilter.equals("All") || values[1].equals(topicFilter)) {
                        String formattedDateTime = values[6].trim();

                        for (DateTimeFormatter inFormat : inputFormats) {
                            try {
                                LocalDateTime parsed = LocalDateTime.parse(formattedDateTime, inFormat);
                                formattedDateTime = parsed.format(outputFormat);
                                break;
                            } catch (Exception ignored) {
                            }
                        }

                        Object[] row = new Object[]{
                            formattedDateTime,
                            values[1],
                            values[2],
                            values[3] + "s",
                            values[4],
                            values[5]
                        };
                        table.addRow(row);
                    }
                }
            }
        } catch (IOException e) {
            throw new ResultException("Failed to load result for user '" + username + "'.", e);
        }

        return table;
    }

    // Overload 2: Get user best attempts for leaderboard display
    public static List<String[]> loadResults(String topicFilter) throws ResultException{
    Map<String, String[]> bestAttempts = new HashMap<>();

    try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
        String line; // Skip header
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length < 7) continue;

            String username = parts[0];
            if (parts[0].equalsIgnoreCase("Username")) {
                continue; // skip header line
            }
            String topic = parts[1];
            int score = Integer.parseInt(parts[2]);
            long timeTaken = Long.parseLong(parts[3]);

            if (topic.equals(topicFilter)) {
                if (!bestAttempts.containsKey(username)) {
                    // store attempts
                    bestAttempts.put(username, parts);
                } else {
                    // compare with existing best attempt
                    String[] existing = bestAttempts.get(username);
                    int existingScore = Integer.parseInt(existing[2]);
                    long existingTime = Long.parseLong(existing[3]);

                    // Replace if new score is higher, or same score but faster time
                    if (score > existingScore || (score == existingScore && timeTaken < existingTime)) {
                        bestAttempts.put(username, parts);
                    }
                }
            }
        }
    } catch (IOException e) {
        throw new ResultException("Failed to load result from file", e);
    }

    // Convert to list and sort
    List<String[]> rankingList = new ArrayList<>(bestAttempts.values());
    rankingList.sort(
            Comparator
                .comparingInt((String[] col) -> -Integer.valueOf(col[2])) // Score descending
                .thenComparingLong(col -> Long.valueOf(col[3]))          // Time ascending
    );

    return rankingList;
}

    
}
