package RGR.Gallery.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Comments implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long commentId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable=false)
    private User author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable=false)
    private Publication publication;

    @Column(length=255, nullable=false)
    private String text;

    public Comments() {
    }

    public Comments(Long commentId, User author, Publication publication, String text) {
        this.commentId = commentId;
        this.author = author;
        this.publication = publication;
        this.text = text;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public User getCommentator() {
        return author;
    }

    public void setCommentator(User commentator) {
        this.author = commentator;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
