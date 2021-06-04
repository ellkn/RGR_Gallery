package RGR.Gallery.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Document {
    private Long documentId;
    private String title;
    private User user;
    private LocalDateTime deletedOn;
    private User deletedBy;
    private LocalDateTime uploadDate;
    private String fullPath;
    private String fileName;
    private String tags;
    private BigDecimal size;

    public Document() {
    }

    public Document(String title, User user, LocalDateTime deletedOn, User deletedBy, LocalDateTime uploadDate, String fullPath, String fileName, String tags, BigDecimal size) {
        this.documentId = documentId;
        this.title = title;
        this.user = user;
        this.deletedOn = deletedOn;
        this.deletedBy = deletedBy;
        this.uploadDate = uploadDate;
        this.fullPath = fullPath;
        this.fileName = fileName;
        this.tags = tags;
        this.size = size;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getDeletedOn() {
        return deletedOn;
    }

    public void setDeletedOn(LocalDateTime deletedOn) {
        this.deletedOn = deletedOn;
    }

    public User getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(User deletedBy) {
        this.deletedBy = deletedBy;
    }

    public LocalDateTime getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDateTime uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getFullPath() {
        return fullPath;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }
}
