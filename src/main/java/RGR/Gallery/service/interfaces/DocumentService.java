package RGR.Gallery.service.interfaces;

import RGR.Gallery.model.Document;

import java.util.List;

public interface DocumentService {
    List<Document> loadDocuments(Long userId);
}
