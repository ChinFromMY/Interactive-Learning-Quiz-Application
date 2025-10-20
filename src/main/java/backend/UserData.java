/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

// Creator: CHIN PEI YI (98485)
// Tester: TIONG WOEI CHIN (101224)

// Store and validate username, store quiz result
public class UserData {
    private static String username;
    private static String password;
    private static final String FILE_PATH = "userdata.csv";
    
    public static String getUsername(){
        return username;
    }
    
    public static void setUsername(String name) {
        username = name;
    }
    
    public static String getPassword(){
        return password;
    }
    
    public static void setPassword(String pw) {
        password = pw;
    }
    
    // Save username and password in csv file
    public static void saveCredentials(String username, String password) throws UserDataException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH,true))) {
            writer.write("=\"" + username + "\"," + "=\"" + password + "\"");  // preserve leading zeros
            writer.newLine();
        } catch (IOException e) {
            throw new UserDataException("Failed to save user credentials", e);
        }
    }
    
    // Validate credentials
    public static boolean validateCredentials(String username, String password) throws UserDataException {
        System.out.println("Starting validation... ");
        
        // reead the dataset
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue; // Skip blank lines
                
                String [] col = line.split(",", -1);
                
                // validate username and password
                if (col.length >= 2) {
                    // Clean up each value: remove =' and trailing "
                    String user = col[0].replace("=\"", "").replace("\"", "").trim();
                    String pass = col[1].replace("=\"", "").replace("\"", "").trim();
                    
                if (user.equals(username) && pass.equals(password)) {
                    System.out.println("User "+ username + " successfully login!");
                    return true;
                } 
            }
            }
        } catch(IOException e) {
            throw new UserDataException("Failed to validate user credentials", e);
        }
        
        return false;
    }
    
}
