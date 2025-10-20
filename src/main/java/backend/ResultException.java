/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

// Creator: HII SIEW CHIENG (97444)
// Tester: CHAN CHIN XUAN (98439)

// Exception handling for Quiz Results
public class ResultException extends Exception {
    public ResultException(String message) {
        super(message);
    }
    
    public ResultException(String message, Throwable cause) {
        super(message, cause);
    }
}
