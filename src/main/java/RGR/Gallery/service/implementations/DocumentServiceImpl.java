package RGR.Gallery.service.implementations;

import RGR.Gallery.dao.DocumentDao;
import RGR.Gallery.model.Document;
import RGR.Gallery.service.interfaces.DocumentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentDao documentDao;

    public DocumentServiceImpl(DocumentDao documentDao) {
        this.documentDao = documentDao;
    }

    public List<Document> loadDocuments(Long userId) {
        return documentDao.loadDocuments(userId);
    }

}
