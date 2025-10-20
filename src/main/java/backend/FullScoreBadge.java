/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

// Creator: TIONG WOEI CHIN (101224)
// Tester: CHIN PEI YI (98485)

// Badge for scoring full marks for each topic
public class FullScoreBadge implements IBadge{
    private final String name;
    private final String description;
    private final String iconPath;
    private final String topicId;
    
    // Constructor
    public FullScoreBadge(String topicId, String name, String description, String iconPath) {
        this.topicId = topicId;
        this.name = name;
        this.description = description;
        this.iconPath = iconPath;
    }
    
    // === Overriden methods from IBadge interface ===
    @Override
    public String getBadgeName() {
        return name;
    }

    @Override
    public String getBadgeDesc() {
        return description;
    }

    @Override
    public String getBadgeIcon() {
        return iconPath;
    }
    
    // Initialise and get Badge for each topic
    public static FullScoreBadge getBadgeForTopic(String topicId) {
        return switch (topicId) {
            case "1" -> new FullScoreBadge(
                    "1",
                    "The Deepfake Primer",
                    "Score 100% on Deepfake Definition Quiz for Topic 1.",
                    "/Images/badge1.png"
            );
            case "2" -> new FullScoreBadge(
                    "2",
                    "Spot the Fake!",
                    "Scored 100% on Deepfake Detection Quiz for Topic 2.",
                    "/Images/badge2.png"
            );
            case "3" -> new FullScoreBadge(
                    "3",
                    "Impact Aware",
                    "Scored 100% on Deepfake Effects Quiz for Topic 3.",
                    "/Images/badge3.png"
            );
            case "4" -> new FullScoreBadge(
                    "4",
                    "Solution Strategist",
                    "Scored 100% on Deepfake Solutions Quiz for Topic 4.",
                    "/Images/badge4.png"
            );
            default -> null;
        };
    }
    
    
    
}
