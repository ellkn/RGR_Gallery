package RGR.Gallery.domain;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Publication implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long publicationId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User author;
    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "album_id", nullable = false)
    private Album album;

    @OneToMany(mappedBy = "publication",cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Comments> comments;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Tags> tags;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date date;
    private boolean forFriends;
    private String imageToken;

    @ManyToMany
    @JoinTable(
            name = "publication_subscriptions",
            joinColumns = { @JoinColumn(name = "publication_id") },
            inverseJoinColumns = { @JoinColumn(name = "subscriber_id") }
    )
    private Set<User> subscribers = new HashSet<>();

    public Publication() {
    }

    public Publication(Long publicationId, User author, String text, Album album, Set<Comments> comments, Set<Tags> tags, Date date, boolean forFriends, String imageToken) {
        this.publicationId = publicationId;
        this.author = author;
        this.text = text;
        this.album = album;
        this.comments = comments;
        this.tags = tags;
        this.date = date;
        this.forFriends = forFriends;
        this.imageToken = imageToken;
    }

    public Long getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(Long publicationId) {
        this.publicationId = publicationId;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Set<Comments> getComments() {
        return comments;
    }

    public void setComments(Set<Comments> comments) {
        this.comments = comments;
    }

    public Set<Tags> getTags() {
        return tags;
    }

    public void setTags(Set<Tags> tags) {
        this.tags = tags;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isForFriends() {
        return forFriends;
    }

    public void setForFriends(boolean forFriends) {
        this.forFriends = forFriends;
    }

    public String getImageToken() {
        return imageToken;
    }

    public void setImageToken(String imageToken) {
        this.imageToken = imageToken;
    }

    public Set<User> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Set<User> subscribers) {
        this.subscribers = subscribers;
    }
}
