/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

// Creator: CHAN CHIN XUAN (98439)
// Tester: HII SIEW CHIENG (97444)

// Exception handling for learning media 
public class MediaException extends Exception {
    public MediaException(String message) {
        super(message);
    }
    
   public MediaException(String message, Throwable cause) {
        super(message, cause);
    }
}
