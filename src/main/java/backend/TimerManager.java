/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.util.TimerTask;
import java.util.function.Consumer;
import javax.swing.SwingUtilities;

// Creator: CHIN PEI YI (98485)
// Tester: TIONG WOEI CHIN (101224)

// Manage Timer during quiz
public class TimerManager {
    private java.util.Timer timer;
    private long startTime;
    private long seconds;
    private boolean timerStarted = false;
    boolean quizEnded = false;
    private Consumer<Long> onTick;  // callback to update timer label
    
    public long getSeconds() {
        return seconds;
    }
    
    // Constructor
    public TimerManager(Consumer<Long> onTick) throws TimerException {
        if (onTick == null) {
            throw new TimerException("Timer callback function cannot be null.");
        }
        this.onTick = onTick;
    }
    
    // Start Timer
    public void startTimer() throws TimerException {
        // DEBUG
        System.out.println("Starting timer... timerStarted = " + timerStarted);
        
        // Check exisitng timer
        if (timerStarted) {
            throw new TimerException("Timer is already running.");
        }
        
        // Start quiz
        quizEnded = false;
        // Get timer
        timer = new java.util.Timer();
        startTime = System.currentTimeMillis();
        timerStarted = true;
        
        TimerTask task = new TimerTask() {
            
            @Override
            public void run() {
                if (quizEnded) {
                    timer.cancel();
                    return;
                }
                long elapsed = System.currentTimeMillis() - startTime;
                seconds = elapsed / 1000;
                SwingUtilities.invokeLater(()->{
                    if (onTick != null) {
                        onTick.accept(seconds);  // update panel
                    }
                });
            }
            
        };
        timer.scheduleAtFixedRate(task,0,1000);
    }
    
    // Stop Timer
    public void stopTimer() {
        // DEBUG
        System.out.println("Stopping timer... timerStarted = " + timerStarted);

        timerStarted = false;
        // End quiz
        quizEnded = true;
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        
    }
   
}
