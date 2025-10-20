/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

// Creator: CHAN CHIN XUAN (98439)
// Tester: HII SIEW CHIENG (97444)

// Learning media item class (images, youtube videos, video url)
public class MediaItem {
    public enum MediaType { IMAGE, YOUTUBE_VIDEO }
    private String filePath;
    private MediaType type;
    private String description;
    private int width;
    private int height;
    private String youtubeUrl;

    //constructor for youtube videos
    public MediaItem(String filePath, MediaType type, String description, int width, int height) {
        this.filePath = filePath;
        this.type = type;
        this.description = description;
        this.width = width;
        this.height = height;
        this.youtubeUrl = null;
    }

    public MediaItem(String youtubeUrl, String description){
        this.filePath = null;
        this.type = MediaType.YOUTUBE_VIDEO;
        this.description = description;
        this.width = 0;
        this.height = 0;
        this.youtubeUrl = youtubeUrl;
    }

    //getters
    public String getFilePath() { return filePath; }
    public MediaType getType() { return type; }
    public String getDescription() { return description; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public String getYoutubeUrl() { return youtubeUrl;}
}
