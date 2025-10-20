/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frontend;
import backend.BadgeException;
import backend.UserData;
import backend.BadgeStorage;
import backend.FullScoreBadge;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// Creator: CHAN CHIN XUAN (98439)
// Tester: HII SIEW CHIENG (97444)

// Quiz Result Panel
public class ResultPanel extends javax.swing.JPanel {
    
    private JPanel mainPanel;
    private FillBlanksPanel fbPanel;
    private TrueFalsePanel tfPanel;
    private MCQPanel mcqPanel;
    private MatchingPanel mcPanel;
    private QuizPanel quizPanel;
    
    // Constructor
    public ResultPanel() {
        initComponents();
    }
    
    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }
    
    
    public void setFillBlanksPanel(FillBlanksPanel fb) {
        this.fbPanel = fb;
    }
    
    public void setTrueFalsePanel(TrueFalsePanel tf) {
        this.tfPanel = tf;
    }
    
    public void setMCQPanel(MCQPanel mcq) {
        this.mcqPanel = mcq;
    }
    
    public void setMatchingPanel(MatchingPanel mc) {
        this.mcPanel = mc;
    }

    public void setQuizPanel(QuizPanel quizPanel) {
        this.quizPanel = quizPanel;
    }
    
    public void setMotivateText(String text) {
        motivateLabel.setText(text);
    }

    public void setScore(int score, int total) {
        resultScoreLabel.setText("Your Score     : " + score + "/" + (total*10));
    }

    public void setTimeTaken(long seconds) {
        timeTakenLabel.setText("Time taken     : " + seconds + "s");
    }

    public void setCorrectCount(int correct) {
        correctLabel.setText("Correct picks : " + correct);
    }

    public void setMistakeCount(int mistakes) {
        mistakeLabel.setText("Mistakes        : " + mistakes);
    }

    public void setBadgeText(String text) {
        badgeTextLabel.setText(text);
    }
    
    public void setBadgeIcon(String imagePath) {
        badgeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagePath)));
    }
    
    // Display result when quiz ends
    public void displayResult(int score, int total, long timeTaken, int correct, int mistakes, String topic) {
        // Scaling motivation message based on score
        if (score <= 100 && score >= 80) {
            setMotivateText("Outstanding!");
        } else if (score <= 79 && score >= 60) {
            setMotivateText("That's good!");
        } else if (score <= 59 && score >= 40) {
            setMotivateText("Good try!");
        } else if (score <= 39 && score >= 20) {
            setMotivateText("You can do better!");
        } else if(score <= 19 && score >= 0) {
            setMotivateText("Don't give up!");
        }
     
        // Get relevant badges
        FullScoreBadge badge = FullScoreBadge.getBadgeForTopic(topic);
        
        if (badge != null) {
            
            String currentUser = UserData.getUsername();
            String badgeName = badge.getBadgeName();
            System.out.println("===Badge result===");
            System.out.println("Current user: " + currentUser);
            System.out.println("Badge name: " + badgeName);
            
            // Win badge
            if (score == 100) {
                // Display new badge earned
                setBadgeIcon(badge.getBadgeIcon());
                setBadgeText("Congrats! New badge '" + badgeName + "' unlock.");
                
                try {
                    // Check collection
                    if (!BadgeStorage.loadBadges(currentUser, badgeName)) {
                        BadgeStorage.saveBadge(currentUser, badgeName); // persis new badge to file
                    } else {
                        // Badge already earned previously
                        setBadgeText("You had already earned '" + badgeName + "' badge.");
                    }
                } catch (BadgeException e) {
                    JOptionPane.showMessageDialog(this, 
                        "An error occurred for loading badges:\n" + e.getMessage(),
                        "Badge Load Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
                
            } else {
                try {
                    // No badge collected
                    if (!BadgeStorage.loadBadges(currentUser,badgeName)) {
                        setBadgeIcon("/Images/badge0.png");
                        setBadgeText("Almost there! Try again and unlock the badge.");
                    } else {
                        setBadgeIcon(badge.getBadgeIcon());
                        // Badge already earned previously
                        setBadgeText("You had already earned '" + badgeName + "' badge.");
                    }
                } catch (BadgeException e) {
                    JOptionPane.showMessageDialog(this, 
                        "An error occurred for loading badges:\n" + e.getMessage(),
                        "Badge Load Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
                
            }
        } 
       
        // Set labels
        setScore(score,total);
        setTimeTaken(timeTaken);
        setCorrectCount(correct);
        setMistakeCount(mistakes);
  
    }
    
    // reset quiz for each topic after quiz ends
    private void resetQuizforTopic() {
        // Switch to QuestionPanel
        CardLayout card = (CardLayout) mainPanel.getLayout();
        switch(quizPanel.getCurrentTopic()) {
            case "1" -> {
                card.show(mainPanel, "fb");
                fbPanel.resetQuiz();
            }
            case "2" -> {
                card.show(mainPanel, "tf");
                tfPanel.resetQuiz();
            }
            case "3" -> {
                card.show(mainPanel, "mc");
                mcPanel.resetQuiz();
            }
            case "4" -> {
                card.show(mainPanel, "mcq");
                mcqPanel.resetQuiz();
            }
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

        motivateLabel = new javax.swing.JLabel();
        timeTakenLabel = new javax.swing.JLabel();
        resultScoreLabel = new javax.swing.JLabel();
        correctLabel = new javax.swing.JLabel();
        badgeIcon = new javax.swing.JLabel();
        mistakeLabel = new javax.swing.JLabel();
        retryButton = new javax.swing.JButton();
        homeButton = new javax.swing.JButton();
        badgeTextLabel = new javax.swing.JLabel();
        viewLeaderboardBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 0, 51));
        setForeground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(430, 670));
        setPreferredSize(new java.awt.Dimension(430, 670));
        setLayout(new java.awt.GridBagLayout());

        motivateLabel.setBackground(new java.awt.Color(51, 0, 51));
        motivateLabel.setFont(new java.awt.Font("Arial Black", 0, 35)); // NOI18N
        motivateLabel.setForeground(new java.awt.Color(255, 255, 255));
        motivateLabel.setText("Perfect!");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        add(motivateLabel, gridBagConstraints);

        timeTakenLabel.setBackground(new java.awt.Color(51, 0, 51));
        timeTakenLabel.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        timeTakenLabel.setForeground(new java.awt.Color(255, 255, 255));
        timeTakenLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        timeTakenLabel.setText("Time taken     : 350s");
        timeTakenLabel.setMaximumSize(new java.awt.Dimension(301, 36));
        timeTakenLabel.setMinimumSize(new java.awt.Dimension(301, 36));
        timeTakenLabel.setPreferredSize(new java.awt.Dimension(301, 36));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(0, 85, 10, 0);
        add(timeTakenLabel, gridBagConstraints);

        resultScoreLabel.setBackground(new java.awt.Color(51, 0, 51));
        resultScoreLabel.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        resultScoreLabel.setForeground(new java.awt.Color(255, 255, 255));
        resultScoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        resultScoreLabel.setText("Your Score     : 100/100 ");
        resultScoreLabel.setMaximumSize(new java.awt.Dimension(301, 36));
        resultScoreLabel.setMinimumSize(new java.awt.Dimension(301, 36));
        resultScoreLabel.setPreferredSize(new java.awt.Dimension(301, 36));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 85, 0, 0);
        add(resultScoreLabel, gridBagConstraints);

        correctLabel.setBackground(new java.awt.Color(51, 0, 51));
        correctLabel.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        correctLabel.setForeground(new java.awt.Color(51, 255, 0));
        correctLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        correctLabel.setText("Correct picks : 5 ");
        correctLabel.setAlignmentY(0.0F);
        correctLabel.setMaximumSize(new java.awt.Dimension(301, 36));
        correctLabel.setMinimumSize(new java.awt.Dimension(301, 36));
        correctLabel.setPreferredSize(new java.awt.Dimension(301, 36));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(10, 135, 0, 0);
        add(correctLabel, gridBagConstraints);

        badgeIcon.setBackground(new java.awt.Color(255, 255, 255));
        badgeIcon.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        badgeIcon.setForeground(new java.awt.Color(255, 0, 0));
        badgeIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        badgeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/badge1.png"))); // NOI18N
        badgeIcon.setToolTipText("");
        badgeIcon.setMaximumSize(new java.awt.Dimension(80, 80));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        add(badgeIcon, gridBagConstraints);

        mistakeLabel.setBackground(new java.awt.Color(51, 0, 51));
        mistakeLabel.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        mistakeLabel.setForeground(new java.awt.Color(255, 0, 0));
        mistakeLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mistakeLabel.setText("Mistakes        : 5");
        mistakeLabel.setMaximumSize(new java.awt.Dimension(301, 36));
        mistakeLabel.setMinimumSize(new java.awt.Dimension(301, 36));
        mistakeLabel.setPreferredSize(new java.awt.Dimension(301, 36));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 135, 30, 0);
        add(mistakeLabel, gridBagConstraints);

        retryButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        retryButton.setForeground(new java.awt.Color(51, 0, 51));
        retryButton.setText("Try Again");
        retryButton.setMaximumSize(new java.awt.Dimension(120, 35));
        retryButton.setMinimumSize(new java.awt.Dimension(120, 35));
        retryButton.setPreferredSize(new java.awt.Dimension(120, 35));
        retryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retryButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        add(retryButton, gridBagConstraints);

        homeButton.setBackground(new java.awt.Color(51, 0, 51));
        homeButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        homeButton.setForeground(new java.awt.Color(255, 255, 255));
        homeButton.setText("Home");
        homeButton.setMaximumSize(new java.awt.Dimension(120, 35));
        homeButton.setMinimumSize(new java.awt.Dimension(120, 35));
        homeButton.setPreferredSize(new java.awt.Dimension(120, 35));
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        add(homeButton, gridBagConstraints);

        badgeTextLabel.setFont(new java.awt.Font("BatangChe", 0, 12)); // NOI18N
        badgeTextLabel.setForeground(new java.awt.Color(255, 255, 255));
        badgeTextLabel.setText("You' ve got Topic 1 Badge!");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 30, 0);
        add(badgeTextLabel, gridBagConstraints);

        viewLeaderboardBtn.setBackground(new java.awt.Color(51, 0, 51));
        viewLeaderboardBtn.setForeground(new java.awt.Color(255, 255, 255));
        viewLeaderboardBtn.setText("View Leaderboard");
        viewLeaderboardBtn.setBorder(null);
        viewLeaderboardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewLeaderboardBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
        add(viewLeaderboardBtn, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        resetQuizforTopic();
        // Switch to QuestionPanel
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "menu");
    }//GEN-LAST:event_homeButtonActionPerformed

    private void retryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retryButtonActionPerformed
       System.out.println("Result Panel, Try again Quiz!");
       resetQuizforTopic();
    }//GEN-LAST:event_retryButtonActionPerformed

    private void viewLeaderboardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewLeaderboardBtnActionPerformed
        resetQuizforTopic();
        LeaderboardPanel lbPanel = new LeaderboardPanel(); // default display of leaderboard
        lbPanel.setMainPanel(mainPanel);
        mainPanel.add(lbPanel, "leaderboard");
        lbPanel.refresh("1");
        // Switch to LeaderBoardPanel
        CardLayout card = (CardLayout)(mainPanel.getLayout());
        card.show(mainPanel,"leaderboard");
    }//GEN-LAST:event_viewLeaderboardBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel badgeIcon;
    private javax.swing.JLabel badgeTextLabel;
    private javax.swing.JLabel correctLabel;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel mistakeLabel;
    private javax.swing.JLabel motivateLabel;
    private javax.swing.JLabel resultScoreLabel;
    private javax.swing.JButton retryButton;
    private javax.swing.JLabel timeTakenLabel;
    private javax.swing.JButton viewLeaderboardBtn;
    // End of variables declaration//GEN-END:variables
}
