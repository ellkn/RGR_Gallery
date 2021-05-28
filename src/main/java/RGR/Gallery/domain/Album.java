package RGR.Gallery.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Album implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long albumId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable=false)
    private User author;
    private String title;
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="album", orphanRemoval = true)
    private Set<Publication> publication;
    private boolean isForFriends;

    public Album() {
    }

    public Album(Long albumId, User author, String title, Set<Publication> publication, boolean isForFriends) {
        this.albumId = albumId;
        this.author = author;
        this.title = title;
        this.publication = publication;
        this.isForFriends = isForFriends;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Publication> getPublication() {
        return publication;
    }

    public void setPublication(Set<Publication> publication) {
        this.publication = publication;
    }

    public boolean isForFriends() {
        return isForFriends;
    }

    public void setForFriends(boolean forFriends) {
        isForFriends = forFriends;
    }
}
