package RGR.Gallery.model;

import java.time.LocalDateTime;

public class Comment {
    private Long commentId;
    private Publication publication;
    private String comment;
    private Document document;
    private LocalDateTime createdOn;
    private User createdBy;
    private LocalDateTime uploadOn;
    private User uploadBy;

    public Comment() {
    }

    public Comment(Long commentId, Publication publication, String comment, Document document, LocalDateTime createdOn, User createdBy, LocalDateTime uploadOn, User uploadBy) {
        this.commentId = commentId;
        this.publication = publication;
        this.comment = comment;
        this.document = document;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.uploadOn = uploadOn;
        this.uploadBy = uploadBy;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getUploadOn() {
        return uploadOn;
    }

    public void setUploadOn(LocalDateTime uploadOn) {
        this.uploadOn = uploadOn;
    }

    public User getUploadBy() {
        return uploadBy;
    }

    public void setUploadBy(User uploadBy) {
        this.uploadBy = uploadBy;
    }
}
