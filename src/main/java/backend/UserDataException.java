/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

// Creator: TIONG WOEI CHIN (101224)
// Tester: CHIN PEI YI (98485)

// Exception handling for User data credentials
public class UserDataException extends Exception{
    public UserDataException(String message) {
        super(message);
    }
    
    public UserDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
