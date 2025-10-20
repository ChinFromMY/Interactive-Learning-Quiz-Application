/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

// Creator: TIONG WOEI CHIN (101224)
// Tester: CHIN PEI YI (98485)

// Exception handling for badge collection
public class BadgeException extends Exception {
    public BadgeException(String message) {
        super(message);
    }
    
    public BadgeException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
