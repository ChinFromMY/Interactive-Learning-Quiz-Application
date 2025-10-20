package backend;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

// Creator: TIONG WOEI CHIN (101224)
// Tester: CHIN PEI YI (98485)

// To store badge collection for each user in CSV file
public class BadgeStorage {
    private static final String FILENAME = "badge_log.csv";

    // Save a badge earned by a user (append mode)
    public static void saveBadge(String username, String badgeName) throws BadgeException {
        if (username == null || username.isEmpty() || badgeName == null || badgeName.isEmpty()) {
            System.err.println("Username or badgeName is empty. Cannot save badge.");
            return;
        }

        File file = new File(FILENAME);
        boolean fileExists = file.exists();

        // Prepare the CSV record line
        String record = String.join(",", username, badgeName) + "\n";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME, true))) {
            // Write header if file doesn't exist
            if (!fileExists) {
                writer.write("Username,BadgeName");
                writer.newLine();
            }
            writer.write(record);
        } catch (IOException e) {
            throw new BadgeException("Failed to save badge to file.", e);
        }
    }

    // Overload 1: Load all badge collection of user
    public static List<String> loadBadges(String username) throws BadgeException {
        List<String> badges = new ArrayList<>();
        if (username == null || username.isEmpty()) return badges;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line; // skip header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 2);
                if (parts.length == 2 && parts[0].equals(username)) {
                    badges.add(parts[1]);
                }
            }
        } catch (IOException e) {
            throw new BadgeException("Failed to load badge from file.", e);
        }
        return badges;
    }

    // Overload 2 : Load user badge collection for specific topic
    public static boolean loadBadges(String username, String badgeName) throws BadgeException{
        List<String> badges = loadBadges(username);
        return badges.contains(badgeName);
    }
}
