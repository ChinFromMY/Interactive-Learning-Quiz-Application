/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;
import backend.MusicException;
import java.awt.CardLayout; 
import java.io.BufferedInputStream;
import java.io.IOException;
import javax.sound.sampled.*;
import javax.swing.*;
import java.io.InputStream;

// Creator: HII SIEW CHIENG (97444)
// Tester: CHAN CHIN XUAN (98439)

// MainFrame
public class MainFrame extends javax.swing.JFrame {
    private Clip backgroundClip;
    private boolean isPlaying = false;
    
    // Constructor
    public MainFrame() {
        initComponents();
        setResizable(false);    // disable window resize
        setLocationRelativeTo(null); // centered window on the screen
        
        // Welcome Panel
        mainPanel.add(welcomePanel, "welcome");
        
        // Login Panel
        LoginPanel loginPanel = new LoginPanel();
        loginPanel.setMainPanel(mainPanel);  
        mainPanel.add(loginPanel, "login"); 
        
        // SignUp Panel
        SignUpPanel signPanel = new SignUpPanel();
        signPanel.setMainPanel(mainPanel);  
        mainPanel.add(signPanel, "signUp"); 
        
        
        // Learning Panel
        LearningPanel learningPanel = new LearningPanel();
        learningPanel.setMainPanel(mainPanel);  
        mainPanel.add(learningPanel, "learning"); 
        
        // Quiz Panel
        QuizPanel quizPanel = new QuizPanel();
        quizPanel.setMainPanel(mainPanel);
        mainPanel.add(quizPanel, "quiz");
        
        // Quiz 1 Panel
        FillBlanksPanel fbPanel = new FillBlanksPanel();
        fbPanel.setMainPanel(mainPanel);
        fbPanel.initializeQuiz();
        mainPanel.add(fbPanel, "fb");
        
        // Quiz 2 Panel
        TrueFalsePanel tfPanel = new TrueFalsePanel();
        tfPanel.setMainPanel(mainPanel);
        tfPanel.initializeQuiz();
        mainPanel.add(tfPanel, "tf");
        
        // Quiz 3 Panel
        MatchingPanel mcPanel = new MatchingPanel();
        mcPanel.setMainPanel(mainPanel);
        mcPanel.initializeQuiz();
        mainPanel.add(mcPanel, "mc");
        
        // Quiz 4 Panel
        MCQPanel mcqPanel = new MCQPanel();
        mcqPanel.setMainPanel(mainPanel);
        mcqPanel.initializeQuiz();
        mainPanel.add(mcqPanel, "mcq");
        
        // Reference to QuizPanel
        quizPanel.setFillBlanksPanel(fbPanel);
        quizPanel.setTrueFalsePanel(tfPanel);
        quizPanel.setMCQPanel(mcqPanel);
        quizPanel.setMatchingPanel(mcPanel);
        
        // Result Panel
        ResultPanel resultPanel = new ResultPanel();
        resultPanel.setMainPanel(mainPanel);
        mainPanel.add(resultPanel, "result");
        
        // Reference to ResultPanel
        fbPanel.setResultPanel(resultPanel);
        tfPanel.setResultPanel(resultPanel);
        mcqPanel.setResultPanel(resultPanel);
        mcPanel.setResultPanel(resultPanel);
        
        // Reference Quiz1-4 Panels
        resultPanel.setQuizPanel(quizPanel);
        resultPanel.setFillBlanksPanel(fbPanel);
        resultPanel.setTrueFalsePanel(tfPanel);
        resultPanel.setMCQPanel(mcqPanel);
        resultPanel.setMatchingPanel(mcPanel);
        
    }
    
    // To play or stop background music 
    public void toggleMusic() {
        try {
            // Music = OFF
            if (isPlaying && backgroundClip != null && backgroundClip.isRunning()) {
                backgroundClip.stop();
                backgroundClip.close(); 
                isPlaying = false;
                musicButton.setIcon(new ImageIcon(getClass().getResource("/Images/musicOff.png")));

            } else {
                // Music = ON
                InputStream audioSrc = getClass().getResourceAsStream("/background.wav");
                if (audioSrc == null) {
                    throw new MusicException("Audio file not found. Ensure it's in the resources folder.");
                }

                InputStream bufferedIn = new BufferedInputStream(audioSrc);
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);

                backgroundClip = AudioSystem.getClip();
                backgroundClip.open(audioStream);
                backgroundClip.loop(Clip.LOOP_CONTINUOUSLY); // loop forever
                backgroundClip.start();
                isPlaying = true;
                musicButton.setIcon(new ImageIcon(getClass().getResource("/Images/musicOn.png")));

            }
        } catch(MusicException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Music Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            MusicException musicErr = new MusicException("An unexpected error occured during music playback", e);
            JOptionPane.showMessageDialog(this, musicErr.getMessage(),"Music Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;
        
        //create the object (the main components)
        mainPanel = new javax.swing.JPanel();
        welcomePanel = new javax.swing.JPanel();
        heading1 = new javax.swing.JLabel();
        heading2 = new javax.swing.JLabel();
        signUpButton = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();
        musicPanel = new javax.swing.JPanel();
        musicButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Deepfake Awareness");
        setMinimumSize(new java.awt.Dimension(440, 670));
        setPreferredSize(new java.awt.Dimension(440, 670));
        setResizable(false);

        mainPanel.setLayout(new java.awt.CardLayout());

        welcomePanel.setBackground(new java.awt.Color(51, 0, 51));
        welcomePanel.setMinimumSize(new java.awt.Dimension(430, 670));
        welcomePanel.setPreferredSize(new java.awt.Dimension(430, 670));
        welcomePanel.setLayout(new java.awt.GridBagLayout());

        heading1.setFont(new java.awt.Font("Elephant", 1, 18)); // NOI18N
        heading1.setForeground(new java.awt.Color(255, 255, 204));
        heading1.setText("<html><div style='text-align: center;'>Have you ever heard about <br>DEEPFAKE?</br></html>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(9, 0, 0, 0);
        welcomePanel.add(heading1, gridBagConstraints);

        heading2.setFont(new java.awt.Font("Yu Gothic Medium", 0, 12)); // NOI18N
        heading2.setForeground(new java.awt.Color(255, 255, 255));
        heading2.setText("Let's unmasking the Digital World....");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.insets = new java.awt.Insets(39, 0, 39, 0);
        welcomePanel.add(heading2, gridBagConstraints);

        signUpButton.setText("First time here?");
        signUpButton.setMinimumSize(null);
        signUpButton.setPreferredSize(new java.awt.Dimension(200, 30));
        signUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 30, 0);
        welcomePanel.add(signUpButton, gridBagConstraints);

        loginButton.setBackground(new java.awt.Color(51, 0, 51));
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("Log me In!");
        loginButton.setPreferredSize(new java.awt.Dimension(200, 30));
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        welcomePanel.add(loginButton, gridBagConstraints);

        mainPanel.add(welcomePanel, "card2");

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        musicPanel.setBackground(new java.awt.Color(51, 0, 51));
        musicPanel.setPreferredSize(new java.awt.Dimension(982, 40));

        musicButton.setBackground(new java.awt.Color(51, 0, 51));
        musicButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/musicOff.png"))); // NOI18N
        musicButton.setBorder(null);
        musicButton.setOpaque(true);
        musicButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                musicButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout musicPanelLayout = new javax.swing.GroupLayout(musicPanel);
        musicPanel.setLayout(musicPanelLayout);
        musicPanelLayout.setHorizontalGroup(
            musicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, musicPanelLayout.createSequentialGroup()
                .addContainerGap(394, Short.MAX_VALUE)
                .addComponent(musicButton)
                .addContainerGap())
        );
        musicPanelLayout.setVerticalGroup(
            musicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, musicPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(musicButton))
        );

        getContentPane().add(musicPanel, java.awt.BorderLayout.NORTH); //fix the music toggle throughout the application 

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void signUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpButtonActionPerformed
        // Switch to SignUpPanel
        CardLayout card = (CardLayout)(mainPanel.getLayout());
        card.show(mainPanel,"signUp");
    }//GEN-LAST:event_signUpButtonActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // Switch to LoginPanel
        CardLayout card = (CardLayout)(mainPanel.getLayout());
        card.show(mainPanel,"login");
    }//GEN-LAST:event_loginButtonActionPerformed

    private void musicButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_musicButtonActionPerformed
        toggleMusic();
    }//GEN-LAST:event_musicButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel heading1;
    private javax.swing.JLabel heading2;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton musicButton;
    private javax.swing.JPanel musicPanel;
    private javax.swing.JButton signUpButton;
    private javax.swing.JPanel welcomePanel;
    // End of variables declaration//GEN-END:variables
}
