package RGR.Gallery.service.implementations;

import RGR.Gallery.dao.CommentDao;
import RGR.Gallery.dao.PublicationDao;
import RGR.Gallery.model.Publication;
import RGR.Gallery.service.interfaces.PublicationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationServiceImpl implements PublicationService {
    private final PublicationDao publicationDao;
    private final CommentDao commentDao;


    public PublicationServiceImpl(PublicationDao publicationDao, CommentDao commentDao) {
        this.publicationDao = publicationDao;
        this.commentDao = commentDao;
    }

    public List<Publication> loadPublications(Long userId) {
        List<Publication> publications = publicationDao.loadPublications(userId);
        for (Publication publication : publications) {
            publication.setComments(commentDao.loadComments(publication.getPublicationId()));
        }
        return publicationDao.loadPublications(userId);
    }
}
