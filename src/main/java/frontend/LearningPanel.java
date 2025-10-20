/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import backend.MediaItem;
import backend.ContentPage;
import backend.MediaException;
import java.io.IOException;
import java.net.URISyntaxException;

// Creator: CHAN CHIN XUAN (98439)
// Tester: HII SIEW CHIENG (97444)

// Learning Contents Panel
public class LearningPanel extends JPanel implements ActionListener, MouseListener, ComponentListener {
    
    //main user interface Components
    private JPanel mainPanel;
    private JPanel centerPanel;
    private JPanel topicButtonsPanel;
    private JPanel contentPanel;
    private JPanel navigationPanel;
    
    //to display content components
    private JTextArea contentTextArea;
    private JScrollPane contentScrollPane;
    private JLabel imageLabel;
    private JButton playVideoButton;
    
    //navigation components
    private JButton[] topicButtons;
    private JButton backMenuButton;
    private JButton nextButton;
    private JButton previousButton;
    
    //layout
    private CardLayout centerCardLayout;
    private boolean showingContent = false;
    
    //content management (pages,videos)
    private int currentTopicIndex = 0;
    private int currentPageIndex = 0;
    private String currentVideoPath = null;
    private String currentYoutubeUrl = null;
    private String[] topicTitles;
    private List<List<ContentPage>> topicContents;
    
    //constructor for learnning panel 
    public LearningPanel() {
        initializeContent();
        setupImprovedLayout();
        setupTopicButtons();
    }
    
    private void initializeContent() {
        this.topicTitles = new String[]{
            "1. Introduction to Deepfakes.", 
            "2. How to Detect Deepfakes?", 
            "3. Consequences of Falling for Deepfakes.", 
            "4. How to Prevent Yourself from Falling for Deepfakes?"
        };
        
        this.topicContents = Arrays.asList(
            createTopic1Content(),
            createTopic2Content(), 
            createTopic3Content(),
            createTopic4Content()
        );
    }
    
    //create content for topic 1: Introduction to Deepfakes
    private List<ContentPage> createTopic1Content() {
    return Arrays.asList(new ContentPage[] {
        new ContentPage("Topic 1: Introduction to Deepfakes", "h1",
            Arrays.asList(
                new MediaItem("images/intro.png", MediaItem.MediaType.IMAGE, "Deepfake Technology Overview", 250, 250),
                new MediaItem("https://youtu.be/ENdRAI-JrDc", "What are Deepfakes?")
            ),
            "What is deepfake technology?",
            "Deepfake technology is a type of artificial intelligence used to create convincing fake images, videos and audio recordings that look and sound real.",
            "The term 'deepfake' is a combination of 'deep learning' and 'fake'.",
            "Deepfakes often transform existing source content where one person is swapped for another."
        ),
        new ContentPage("How does deepfake technology work?", "h2",
            Arrays.asList(
                new MediaItem("images/howdoesdfworks.png", MediaItem.MediaType.IMAGE, "How does deepfakes works?", 250, 250),
                new MediaItem("https://www.youtube.com/watch?v=gYGkOrpiSDE",  "How Deepfake algorithm works?")
            ),
            "Deepfakes use two algorithms to create and refine fake content:",
            "a. Generator: Creates fake content by learning from real images and videos.",
            "b. Discriminator: Analyzes content quality and provides feedback to generator to improve the quality of the fake content.",
            "The 'generator' algorithm is trained using sample imagery, audio and video to create a new piece of media or manipulate an existing one.",
            "The discriminator algorithm is trained to distinguish between real and fake content, providing feedback to the generator to improve its output.",
            "This process is repeated until the generator produces content that is indistinguishable from real media.",
            "The combination of the generator and discriminator algorithms creates a generative adversarial network (GAN).",
            "A GAN uses deep learning to recognize patterns in data and generate new content that mimics those patterns",
            "Basically, it works like this:",
            "1. The generator creates and discriminator algorithms analyze data from media samples.",
            "2. The generator creates fake content based on the patterns it learns.",
            "3. The discriminator checks for inconsistencies between the samples and the deepfake.",
            "4. The generator fixes inconsistencies the discriminator finds in the deepfake, and resubmits the deepfake to the discriminator.",
            "5. Steps 3 and 4 repeat until the discriminator can find no more inconsistencies."
        ),                
        new ContentPage("How are deepfakes commonly used?", "h2",
            Arrays.asList(
                new MediaItem("images/deepfakeusage.png", MediaItem.MediaType.IMAGE, "Uses of Deepfakes", 250, 250),
                new MediaItem("https://www.youtube.com/watch?v=3DCZD2x1r9A", "Deepfake usage in industry")
            ),            
            "Deepfakes can be used for various purposes, both positive and negative:",
            "• Art: Deepfakes are used to generate new music using existing artist's work.",
            "• Customer service: Used for personalized responses and call forwarding.",
            "• Entertainment: Hollywood movies and video games clone actors' voices.",
            "• Education: AI tutors offering personalized support to students."
        ),
        new ContentPage("Are deepfakes legal?", "h2",
            Arrays.asList(
                new MediaItem("images/deepfake1.png", MediaItem.MediaType.IMAGE, "Legal aspects of Deepfakes", 250, 250),
                new MediaItem("https://www.youtube.com/watch?v=p4E-tVzwvsQ", "Rise of Deepfake")
            ),  
            "Deepfakes are generally legal and there's no law against creating or using them.",
            "• Art: Deepfakes are used to generate new music using the existing bodies of an artist's work.",
            "• Caller response services: These services use deepfakes to provide personalized responses to caller requests that involve call forwarding and other receptionist services.",
            "• Customer phone support: These services use fake voices for simple tasks such as checking an account balance or filing a complaint.",
            "• Entertainment: Hollywood movies and video games clone and manipulate actors' voices for certain scenes. Entertainment mediums use this when a scene is hard to shoot, in post-production when an actor is no longer on set to record their voice, or to save the actor and the production team time.",
            "• Education: Education platforms are also using deepfake technology to develop AI tutors offering personalized support to students. For example, Claude, an educational AI assistant from Anthropic, answers students' queries, clarifies concepts and identifies gaps in understanding."
        ),
        new ContentPage("How are deepfakes dangerous?", "h2",
            Arrays.asList(
                new MediaItem("images/deepfakedangers.png", MediaItem.MediaType.IMAGE, "Dangers of deepfakes", 250, 250),
                new MediaItem("https://www.youtube.com/watch?v=HUXE83knjh8", "Dangers of Deepfakes")
            ), 
            "1. Can make people believe false information.",
            "2. Blackmail and reputational harm in legally compromising situations.",
            "3. Political misinformation by threat actors for nefarious purposes.",
            "4. Creating revenge porn where women are disproportionately harmed."
        )
        });
    }

    //content for topic 2: How to detect deepfakes
    private List<ContentPage> createTopic2Content() {
    return Arrays.asList(new ContentPage[] {
        new ContentPage("Topic 2: How to Detect Deepfakes?", "h1",
            Arrays.asList(
                new MediaItem("images/howtoidentify.jpg", MediaItem.MediaType.IMAGE, "Uses of Deepfakes?", 250, 250),
                new MediaItem("https://www.youtube.com/watch?v=yiXzKN7M2f0", "How to detect Deepfake 1"),
                new MediaItem("https://www.youtube.com/watch?v=BuufkPTFt0E", "How to detect Deepfake 2")
            ), 
            "Methods to detect deepfakes",
            "1. Unnatural or awkward facial positioning or body or eye movements",
            "2. Mismatched lip movements and speech",
            "3. Unnatural coloring",
            "4. Videos that look odd when zoomed in or magnified",
            "5. Monotone or robotic voice",
            "6. Tiny deviations in the reflected light in the eyes of the subject",
            "7. The aging of the skin doesn't match the aging of the hair and eyes",
            "8. Missing body parts",
            "9. Glasses either have no glare or have too much and the glare angle stays the same despite the person's movements"
        ),
            new ContentPage("Identify deepfakes in textual wise", "h2",
                Arrays.asList(
                new MediaItem("images/deepfaketextual.png", MediaItem.MediaType.IMAGE, "Uses of Deepfakes?", 600, 400)
                ), 
            "In textual deepfakes, look for these indicators:",
            "1. Misspellings",
            "2. Sentences that don't flow naturally",
            "3. Suspicious source email addresses",
            "4. Phrasing that doesn't match the supposed sender",
            "5. Out-of-context messages",
            ""
        ),
            new ContentPage("Detection Techniques", "h2",
                Arrays.asList(
                new MediaItem("images/detectiontools.png", MediaItem.MediaType.IMAGE, "Uses of Deepfakes?", 600, 400)
                ),              
            "1. Manual checks:",
            "• Observe inconsistencies in facial expressions, background blur, or voice timing.",
            "• Play the video at slower speeds to spot glitches.",
            "",
            "2. Use AI detection tools:",
            "• Programs like Microsoft Video Authenticator, Deepware Scanner, or Sensity AI.",
            "",
            "3. Verification Methods:",
            "• Check official/public sources.",
            "• Use reverse image/video search to check for duplicates or edits.",
            "• Encourage the public to report suspicious content using platform tools or cybercrime hotlines."
        )
    });
    }
    
    //content for topic 3: Consequences of Falling for Deepfakes
    private List<ContentPage> createTopic3Content() {
    return Arrays.asList(new ContentPage[] {
        new ContentPage("Topic 3: Consequences of Falling for Deepfakes", "h1",
            Arrays.asList(
                new MediaItem("images/consequences.png", MediaItem.MediaType.IMAGE, "Uses of Deepfakes?", 600, 400),
                new MediaItem("https://www.youtube.com/watch?v=PpqGFHdVoUo", "Threat of Deepfakes")
            ),
            "Consequences of falling into the trap of deepfakes:",
            "",
            "1. Reputational Damage:",
            "• Personal reputation: Shame or judgment from others",
            "• Professional impact: Career harm, job loss, damaged relationships",
            "• Public figures: Loss of public trust",
            "",
            "2. Legal Troubles:",
            "• False accusations and fake evidence in court",
            "• Privacy law violations",
            "",
            "3. Social Consequences:",
            "• Community backlash and online 'cancelling'",
            "• Social isolation",
            "",
            "4. Mental Health Issues:",
            "• Anxiety and paranoia",
            "• Depression from public embarrassment",
            "• In extreme cases, suicidal thoughts",
            "",
            "5. Financial Loss:", 
            "• Scams through voice cloning",
            "• Legal expenses for proving content is fake",
            "• Loss of income opportunities",
            "",
            "6. Victim Blaming:",
            "• Being blamed for 'creating' or 'allowing' the content",
            "• Retraumatization from defending oneself"
        )
    });
    }
    
    //content for topic 4: solutions and prevention
    private List<ContentPage> createTopic4Content() {
        return Arrays.asList(new ContentPage[] {
            new ContentPage("Topic 4: Solutions and Prevention", "h1",
                Arrays.asList(
                    new MediaItem("images/riseofdf.png", MediaItem.MediaType.IMAGE, "Uses of Deepfakes?", 600, 400)
                ), 
                "What to do if you're a victim:",
                "• Don’t suffer silently. Inform trusted people and your institution or employer.",
                "2. Report the Incident:",
                "• Use social media platforms’ reporting tools to flag the content.",
                "• Lodge a report to authorities such as:",
                "Cybersecurity agencies",
                "Local police departments (cybercrime units)",
                "Legal advisors or digital forensics experts",
                "3. Seek Profesional Help:",
                "a. For emotional trauma: reach out to mental health counselors.",
                "b. For legal advice: consult a lawyer familiar with digital rights."
            ),
            new ContentPage("How to prevent yourself from falling for Deepfakes", "h2",
                Arrays.asList(
                    new MediaItem("images/deepfakeprotect.png", MediaItem.MediaType.IMAGE, "Protect Yourself against Deepfake", 600, 400)
                ),
    "Protect Your Digital Identity:",
                "• Avoid sharing sensitive photos or videos publicly",
                "• Don't overshare personal information (e.g., full name, address, date of birth) online",
                "Be Cyber-Aware:",
                "• Think before clicking unknown links or joining video calls from unknown sources.",
                "• Use privacy settings on social media to control who can see your content.",
                "Educate Yourself and Others:",
                "• Attend workshops or courses on digital literacy",
                "• Stay updated with the latest AI and cybersecurity trends.",
                "Use Secure Technology:",
                "• Enable two-factor authentication (2FA) on all important accounts.",
                "• Install verified security software to protect devices.",
                "Critical Thinking:",
                "• Don't believe everything you see or hear immediately",
                "• Always cross-verify important news, especially sensational or controversial videos."
            ),
            new ContentPage("Companies offering deepfake protection:", "h2",
                Arrays.asList(
                    new MediaItem("images/deepfakeprotectiontools.png", MediaItem.MediaType.IMAGE,"Tools to detect deepfakes", 600, 400)
                ),
     "1. Adobe:",
                "provides a system that lets creators attach a signature to videos and photos with details about their creation.",
                "2. Intel FakeCatcher",
                "prioritizes speed and efficiency by analyzing subtle physiological details such as pixel variations in blood flow to achieve high accuracy in real-time detection.",
                "3. Microsoft",
                "offers AI-powered deepfake detection software that analyzes videos and photos to provide a confidence score that shows whether the media has been manipulated.",
                "4. Operation Minerva:",
                "uses catalogs of previously discovered deepfakes to tell if a new video is simply a modification of an existing fake that has been discovered and given a digital fingerprint.",
                "5. Sensity AI:",
                "offers a detection platform that uses deep learning to spot indications of synthetic media in the same way antimalware tools look for virus and malware signatures. Users are alerted via email when they view a deepfake."
            )
        });
    }
    
    //setup the layout
    private void setupImprovedLayout() {
        this.removeAll();
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(51, 0, 51));

        JPanel headerPanel = setupHeaderPanel();
                
        //create center panel with cardlayout
        setupCenterPanel();
        
        //ddd to main panel
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        
        centerCardLayout.show(centerPanel, "buttons");
    }
    
    //header panel
    private JPanel setupHeaderPanel() {
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(51, 0, 51));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel titleLabel = new JLabel("Explore & Learn!", SwingConstants.CENTER);
        titleLabel.setForeground(new Color(255,255,204));
        titleLabel.setFont(new Font("DialogInput", Font.BOLD, 24));
        
        backMenuButton = new JButton();
        backMenuButton.setBackground(new Color(51, 0, 51));
        backMenuButton.setForeground(new java.awt.Color(255, 255, 204));
        backMenuButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        backMenuButton.setFocusPainted(false);
        backMenuButton.addActionListener(e -> handleBackButton());
        backMenuButton.setFont(new java.awt.Font("STHupo", 1, 24)); // NOI18N
        backMenuButton.setText("<");
        backMenuButton.setBorder(null);
        
        headerPanel.add(backMenuButton, BorderLayout.WEST);
        headerPanel.add(titleLabel, BorderLayout.CENTER);
        
        return headerPanel;
    }
    
    //center panel (content part) using card layout 
    private void setupCenterPanel() {
        centerPanel = new JPanel();
        centerCardLayout = new CardLayout();
        centerPanel.setLayout(centerCardLayout);
        centerPanel.setBackground(new Color(51, 0, 51));
        
        setupTopicButtonsPanel();
        setupContentPanel();
        
        centerPanel.add(topicButtonsPanel, "buttons");
        centerPanel.add(contentPanel, "content");
    }
    
    //topic buttons 
    private void setupTopicButtonsPanel() {
        topicButtonsPanel = new JPanel(new GridBagLayout());
        topicButtonsPanel.setBackground(new Color(51, 0, 51));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        
        topicButtons = new JButton[4];
        
        for (int i = 0; i < 4; i++) {
            gbc.gridx = i % 2;
            gbc.gridy = i / 2;
            topicButtons[i] = createStyledButton(topicTitles[i], i);
            topicButtonsPanel.add(topicButtons[i], gbc);
        }
    }
    
    //design the topic button 
    private JButton createStyledButton(String text, int index) {
        JButton button = new JButton("<html><center>" + text + "</center></html>");
        button.setPreferredSize(new Dimension(300, 100));
        button.setBackground(new Color(102, 51, 102));
        button.setForeground(Color.WHITE);                  //color
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.WHITE, 2),        
            BorderFactory.createEmptyBorder(10, 15, 10, 15)     //so that the text inside the button is not too close to the border
        ));
        button.setFocusPainted(false);                      //make the button outer layout solid  (not dashed outline)
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));    //change cursor to hand when u hovering around the topic button
        
        addHoverEffect(button);
        button.addActionListener(e -> showTopicContent(index));    //after clicking one of the topic buttons, it will show the content 
        
        return button;
    }
    
    //design the content panel (enable user to scroll and navigate to previous or next topic)
    private void setupContentPanel() {
        contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(new Color(51, 0, 51));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        setupTextContentArea();
        setupNavigationPanel();

        contentPanel.add(contentScrollPane, BorderLayout.CENTER);
        contentPanel.add(navigationPanel, BorderLayout.SOUTH);
    }
    
    //design the text for the tutorial content 
    private void setupTextContentArea() {

        JPanel contentContainer = new JPanel(new BorderLayout());
        contentContainer.setBackground(Color.WHITE);

        //setting up the image label (set as white background)
        imageLabel = new JLabel("", SwingConstants.CENTER);
        imageLabel.setBackground(Color.WHITE);
        imageLabel.setOpaque(true);    //nakes the background color visible
        imageLabel.setVisible(false);  //initally hidden, will show when image is loaded

        //design text area
        contentTextArea = new JTextArea();
        contentTextArea.setEditable(false);   //read only (user cant edit the text)
        contentTextArea.setBackground(Color.WHITE);    
        contentTextArea.setForeground(Color.BLACK);
        contentTextArea.setFont(new Font("Arial", Font.PLAIN, 13));
        contentTextArea.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        contentTextArea.setLineWrap(true);   //text will jump to next line when it reaches end of the text area
        contentTextArea.setWrapStyleWord(true);  //make sure the word is not cut off when jump to the next line

        //create and design video button
        playVideoButton = new JButton("Play Video");
        playVideoButton.setBackground(new Color(102, 51, 102));
        playVideoButton.setForeground(Color.WHITE);
        playVideoButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        playVideoButton.setFocusPainted(false);    //remove the dotted outline when button is clicked
        playVideoButton.setVisible(false);

        //when the playvideobutton is clicked, it will call the playCurrentVideo method
        playVideoButton.addActionListener(e -> {
            try {
                playCurrentVideo();
            } catch (URISyntaxException ex) {                     //if url format wrong, then show error dialog
                JOptionPane.showMessageDialog(this, 
                        "Invalid video URL format:\n" + ex.getMessage(),
                        "URL Syntax Error", 
                        JOptionPane.ERROR_MESSAGE);
            } catch (MediaException ex) {                       //if video cant play, show error dialog (play from local video player)
                JOptionPane.showMessageDialog(this, 
                        "An error occurred for display video:\n" + ex.getMessage(),
                        "Video Display Error", 
                        JOptionPane.ERROR_MESSAGE);
            } 
        });

        //creating video panel container (create a panel to hold the video button)
        JPanel videoPanel = new JPanel(new FlowLayout());   //JPanel by default has flowlayout, so the flowlayout is used to center the button
        videoPanel.setBackground(Color.WHITE);
        videoPanel.add(playVideoButton);

        //assemble the layout
        contentContainer.add(imageLabel, BorderLayout.NORTH);
        contentContainer.add(contentTextArea, BorderLayout.CENTER);
        contentContainer.add(videoPanel, BorderLayout.SOUTH);

        //create a scroll pane to hold the content container (wrap the content container in a scroll pane)
        contentScrollPane = new JScrollPane(contentContainer);
        contentScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        contentScrollPane.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

        //add component listener to handle window/frame/main panel resizing
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e){
                if(showingContent){
                    displayCurrentPage();
                }
            }
        });
    }
    
    //design the navigation button
    private void setupNavigationPanel() {
        navigationPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        navigationPanel.setBackground(new Color(51, 0, 51));
        navigationPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        
        previousButton = createNavigationButton("← Previous");
        nextButton = createNavigationButton("Next →");
        
        previousButton.addActionListener(e -> navigatePrevious());
        nextButton.addActionListener(e -> navigateNext());
        
        navigationPanel.add(previousButton);
        navigationPanel.add(Box.createHorizontalStrut(20));
        navigationPanel.add(nextButton);
    }
    
    //makes sure the button is having the same style 
    private JButton createNavigationButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(102, 51, 102));
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(120, 35));
        addHoverEffect(button);
        return button;
    }
    
    //back button stuffs
    private void handleBackButton() {       
        if (showingContent) {      //if user in view the content, and click the back button on the header panel, it will return user back to the 4 topic buttons
            showTopicButtons();
        } else {             //when user is in the topic button interface, if user click the back button, it will return to main menu.
            CardLayout card = (CardLayout)(mainPanel.getLayout());
            card.show(mainPanel, "menu");
        }
    }
    
    //show topic content is called when a topic button is clicked 
    private void showTopicContent(int topicIndex) {
        //check if the topic index is within the range of topicContents list
        if (topicIndex >= 0 && topicIndex < topicContents.size()) {
            currentTopicIndex = topicIndex;   //set which topic the user is currently viewing
            currentPageIndex = 0;   //so user always start from the beginning of the topic when they click on the topic button
            
            backMenuButton.setText("<");
            displayCurrentPage();    //load and display the first page of the selected topic
            updateNavigationButtons(); //update the navigation buttons based on the current topic and page index
            
            centerCardLayout.show(centerPanel, "content");   //show the content panel with the topic content
            showingContent = true;    //indicate that user is viewing the content of the topic
        }
    }
    
    private void showTopicButtons() {
        backMenuButton.setText("<");
        centerCardLayout.show(centerPanel, "buttons");
        showingContent = false;    //if user is already on the topic button screen, once they click the back button, will return them to the main menu
    }
    
    private void navigatePrevious() {
        //Debugging 4: track navigation button clicked
        System.out.println("Previous button clicked");
        if (currentPageIndex > 0) {         //if u not on 1st page, then go to the previous page
            displayCurrentPage();
            currentPageIndex--;         
        } else if (currentTopicIndex > 0) {     //if u are on the 1st page, and there is previous topic, then go to the last page of the previous topic
            currentTopicIndex--;
            currentPageIndex = topicContents.get(currentTopicIndex).size() - 1;
            displayCurrentPage();
        }
        updateNavigationButtons();   //update the button states based on the user current position in the content
    }
    
    private void navigateNext() {
        //Debugging 5: track navigation button clicked
        System.out.println("Next Button clicked");

        //to get all pages for the current topic
        List<ContentPage> currentTopicPages = topicContents.get(currentTopicIndex);

        //if u are not on the last page, then go one page forward
        if (currentPageIndex < currentTopicPages.size() - 1) {
            currentPageIndex++;
            displayCurrentPage();

        //if u are on the last page, and there's no next topic, then stay on the last page
        } else if (currentTopicIndex < topicContents.size() - 1) {
            currentTopicIndex++;
            currentPageIndex = 0;
            displayCurrentPage();
        }
        //if u are on the last page, and there's a next topic, jump to the 1st page of the next topic
        updateNavigationButtons();
    }
    
    private void updateNavigationButtons() {
        boolean isAtBeginning = (currentTopicIndex == 0 && currentPageIndex == 0);
        boolean isAtEnd = (currentTopicIndex == topicContents.size() - 1 && 
                          currentPageIndex == topicContents.get(currentTopicIndex).size() - 1);
        
        //Debugging 6: Track Page Boundary Conditions
        System.out.println("Navigation buttons updated - isAtBeginning: " + isAtBeginning + ", isEnd: " + isAtEnd);
        
        //disabled the button if u are at the beginning or end of the content
        previousButton.setEnabled(!isAtBeginning);
        nextButton.setEnabled(!isAtEnd);
        
        //changes the text of the previous button depending whether user go to a new topic or just previous page
        if (currentPageIndex == 0 && currentTopicIndex > 0) {
            previousButton.setText("← Previous Topic");
        } else {
            previousButton.setText("← Previous");
        }
        
        //changes the text of the next button if u are at the last page of a topic and there's more content in the next topic
        List<ContentPage> currentTopicPages = topicContents.get(currentTopicIndex);
        if (currentPageIndex == currentTopicPages.size() - 1 && currentTopicIndex < topicContents.size() - 1) {
            nextButton.setText("Next Topic →");
        } else {
            nextButton.setText("Next →");
        }
    }
    
    //ensures u are within the valid topic list and print the index for debugging
    private void displayCurrentPage() {
        if (currentTopicIndex >= 0 && currentTopicIndex < topicContents.size()) {
            //Debugging 1: Track Topic/Page Being Displayed
            System.out.println("Displaying Topic Index: " + currentTopicIndex + ", Page Index: " + currentPageIndex);

            //retrieve the current topic's pages 
            List<ContentPage> pages = topicContents.get(currentTopicIndex);
            if (currentPageIndex >= 0 && currentPageIndex < pages.size()) {
                ContentPage currentPage = pages.get(currentPageIndex);
                
                //null check 
                //if pages exists, then display media (images, videos) & text content

                if(currentPage != null){
                    displayMedia(currentPage.getMediaItems());
                    displayTextContent(currentPage, pages);
                }
            }
        }
    }

    
    //display images and videos
    private void displayMedia(List<MediaItem> mediaItems) {
        imageLabel.setIcon(null);
        imageLabel.setVisible(false);
        playVideoButton.setVisible(false);
        currentVideoPath = null;
        currentYoutubeUrl = null;
        
        if (mediaItems != null && !mediaItems.isEmpty()) {
            MediaItem firstImage = mediaItems.stream()
                .filter(item -> item.getType() == MediaItem.MediaType.IMAGE)
                .findFirst()
                .orElse(null);
                
            if (firstImage != null) {
                //Debugging 2: Track Media Selection (Image and Video)
                System.out.println("Loading image: " + firstImage.getFilePath());
                try {
                    loadAndDisplayImage(firstImage);
                } catch (MediaException e) {
                    JOptionPane.showMessageDialog(this, 
                        "An error occurred for loading image:\n" + e.getMessage(),
                        "Image Loading Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
                imageLabel.setVisible(true);
            }
            
            MediaItem firstVideo = mediaItems.stream()
                .filter(item -> item != null && item.getType() == MediaItem.MediaType.YOUTUBE_VIDEO)
                .findFirst()
                .orElse(null);
                
            if (firstVideo != null) {
                //Debugging 3: Track Media Selection (Image and Video)
                System.out.println("Preparing video: " + firstVideo.getYoutubeUrl());
                currentYoutubeUrl = firstVideo.getYoutubeUrl();
                currentVideoPath = firstVideo.getFilePath();
                playVideoButton.setText("▶ Play: " + firstVideo.getDescription());
                playVideoButton.setVisible(true);
            }
        }
    }
    

    private void displayTextContent(ContentPage currentPage, List<ContentPage> pages) {
        StringBuilder textContent = new StringBuilder();
        
        textContent.append("Topic ").append(currentTopicIndex + 1).append(" of ").append(topicContents.size());
        textContent.append(" | Page ").append(currentPageIndex + 1).append(" of ").append(pages.size());
        textContent.append("\n").append("=".repeat(41)).append("\n\n");

        String title = currentPage.getTitle();
        textContent.append(title).append("\n");
        textContent.append("-".repeat(70)).append("\n\n");
  
              
        for (String line : currentPage.getContent()) {
            if (line.startsWith("<img")) {
                textContent.append("[IMAGE: Diagram/Illustration]\n\n");
            } else if (!line.contains("<html>") && !line.contains("</html>")) {
                textContent.append(line).append("\n\n");
            }
        }
        
        contentTextArea.setText(textContent.toString());
        contentTextArea.setCaretPosition(0);
    }
    

    private void loadAndDisplayImage(MediaItem imageItem) throws MediaException {
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/" + imageItem.getFilePath()));
            if (icon.getIconWidth() == -1) {
                icon = new ImageIcon(imageItem.getFilePath());
            }
            
            if (icon.getIconWidth() > 0) {
                Image img = icon.getImage();

                //get the container width that adjusting for mobile screens
                int containerWidth = this.getWidth() > 0 ? this.getWidth() : 400;
                int maxWidth = Math.min(containerWidth - 40, 350); // Leave some padding, max 350px
                int maxHeight = 250; // Reasonable height for mobile                

                //calculate scaled dimensions while maintain the ratio
                int originalWidth = icon.getIconWidth();
                int originalHeight = icon.getIconHeight();

                double aspectRatio = (double) originalWidth / originalHeight;
                int scaledWidth = maxWidth;
                int scaledHeight = (int) (maxWidth / aspectRatio);
            
                //if the height is too large, scale by height instead
                if (scaledHeight > maxHeight) {
                    scaledHeight = maxHeight;
                    scaledWidth = (int) (maxHeight * aspectRatio);
                }

                Image scaledImg = img.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
                    imageLabel.setIcon(new ImageIcon(scaledImg));
                    imageLabel.setText("");
            }else{
                imageLabel.setIcon(null);
                imageLabel.setText("Image not found: " + imageItem.getDescription());
                System.err.println("Image file not found: " + imageItem.getFilePath());
            }
        } catch (Exception e) {
            imageLabel.setIcon(null);
            imageLabel.setText("Error loading image: " + imageItem.getDescription());
            System.err.println("Error loading image: " + e.getMessage());
            throw new MediaException("Failed to load image: " + imageItem.getFilePath(), e);
        }
    }
    
    private void playCurrentVideo() throws URISyntaxException, MediaException{
        try{
            String urlToOpen = null;

            //check whether there is a youtube video
            if(currentYoutubeUrl != null){
                urlToOpen = currentYoutubeUrl;
            }else if(currentVideoPath != null){
                urlToOpen = currentVideoPath;
            }
            
            //Debugging 7: Track Video Opening 
            System.out.println("Opening video URL/path: " + urlToOpen);
            if (urlToOpen != null) {
                String os = System.getProperty("os.name").toLowerCase();
                
                if (currentYoutubeUrl != null) {
                    //open youTube URL using external browser
                    if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                        Desktop.getDesktop().browse(new java.net.URI(urlToOpen));
                    } else {
                        // Fallback for systems without Desktop support
                        if (os.contains("win")) {
                            new ProcessBuilder("cmd", "/c", "start", "\"\"", urlToOpen).start();
                        } else if (os.contains("mac")) {
                            new ProcessBuilder("open", urlToOpen).start();
                        } else {
                            new ProcessBuilder("xdg-open", urlToOpen).start();
                        }
                    }
                } else {
                    //open local video file in default media player
                    if (os.contains("win")) {
                        new ProcessBuilder("cmd", "/c", "start", "\"\"", urlToOpen).start();
                    } else if (os.contains("mac")) {
                        new ProcessBuilder("open", urlToOpen).start();
                    } else {
                        new ProcessBuilder("xdg-open", urlToOpen).start();
                    }
                }
            }
        } catch (IOException ex) {
            throw new MediaException("Failed to display video.", ex);
        } 
    }
        
    private void addHoverEffect(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(153, 102, 153));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(102, 51, 102));
            }
        });
    }
    

    private void setupTopicButtons() {
    }
    
    //get content for specific page
    public ContentPage getTopicPage(int topicIndex, int pageIndex) {
        if (topicIndex >= 0 && topicIndex < topicContents.size()) {
            List<ContentPage> pages = topicContents.get(topicIndex);
            if (pageIndex >= 0 && pageIndex < pages.size()) {
                return pages.get(pageIndex);
            }
        }
        return null;
    }
    

    public List<ContentPage> getTopicPages(int topicIndex) {
        if (topicIndex >= 0 && topicIndex < topicContents.size()) {
            return topicContents.get(topicIndex);
        }
        return new ArrayList<>();
    }
    
    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }                      


    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle action events if needed
    }
    
    @Override
    public void mouseClicked(MouseEvent e) { }
    
    @Override
    public void mousePressed(MouseEvent e) { }
    
    @Override
    public void mouseReleased(MouseEvent e) { }
    
    @Override
    public void mouseEntered(MouseEvent e) { }
    
    @Override
    public void mouseExited(MouseEvent e) { }
    
    @Override
    public void componentResized(ComponentEvent e) { }
    
    @Override
    public void componentMoved(ComponentEvent e) { }
    
    @Override
    public void componentShown(ComponentEvent e) { }
    
    @Override
    public void componentHidden(ComponentEvent e) { }
}
        
                   