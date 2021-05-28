package RGR.Gallery.service;

import RGR.Gallery.domain.Comments;
import RGR.Gallery.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentsService {
    @Autowired
    CommentsRepository commentsRepository;
    public void save(Comments comment) {
        commentsRepository.save(comment);
    }

    public void delete(Comments comment) {
        commentsRepository.delete(comment);
    }

}
