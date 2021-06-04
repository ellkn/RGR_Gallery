package RGR.Gallery.model;

import java.util.List;

public class Publication {
    private Long publicationId;
    private User user;
    private String title;
    private Document document;
    private List<Comment> comments;

    public Publication() {
    }

    public Publication(User user, String title, Document document) {
        this.user = user;
        this.title = title;
        this.document = document;
    }

    public Long getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(Long publicationId) {
        this.publicationId = publicationId;
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

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
