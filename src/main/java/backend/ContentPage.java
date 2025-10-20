/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Creator: CHAN CHIN XUAN (98439)
// Tester: HII SIEW CHIENG (97444)

// Learning Content
public class ContentPage implements ILearningContent {
    private String title;
    private String type;
    private List<MediaItem> mediaItems;
    private List<String> content;

    //constructor for contentpage 
    public ContentPage(String title, String type, List<MediaItem> mediaItems, String... content) {
        this.title = title;
        this.type = type;
        this.mediaItems = mediaItems;
        this.content = Arrays.asList(content);
    }

    //constructor for pages without media
    public ContentPage(String title, String type, String... content) {
        this.title = title;
        this.type = type;
        this.mediaItems = new ArrayList<>();
        this.content = Arrays.asList(content);
    }
    
    // === Overriden methods from ILearningContent interface ===
    @Override
    public String getTitle() { 
        return title; 
    }
    
    @Override
    public String getType() { 
        return type; 
    }
    
    @Override
    public List<String> getContent() { 
        return content; 
    }
    
    public List<MediaItem> getMediaItems() { 
        return mediaItems; 
    }
    
}