package RGR.Gallery.model;

import java.util.List;

public class Album {

    private Long albumId;
    private User user;
    private String title;
    private String description;
    private Boolean isShared;
    private List<Document> documents;

    public Album() {
    }

    public Album(User user, String title, String description, Boolean isShared) {
        this.user = user;
        this.title = title;
        this.description = description;
        this.isShared = isShared;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getShared() {
        return isShared;
    }

    public void setShared(Boolean shared) {
        isShared = shared;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
}
