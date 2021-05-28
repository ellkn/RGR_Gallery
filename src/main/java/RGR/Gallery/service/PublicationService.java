package RGR.Gallery.service;

import RGR.Gallery.domain.Album;
import RGR.Gallery.domain.Publication;
import RGR.Gallery.domain.User;
import RGR.Gallery.repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
public class PublicationService {
    @Autowired
    PublicationRepository publicationRepository;
    public void save(Publication publication) {
        publicationRepository.save(publication);
    }

    public void delete(Publication publication) {
        publicationRepository.delete(publication);
    }


    public Page<Publication> findByAlbum(Album album, Pageable pageable) {
        return publicationRepository.findImagesByAlbum(album, pageable);
    }


    public Page<Publication> findByAlbumClosedAndTag(boolean status, String s, Pageable pageable) {
        return publicationRepository.findByAlbumClosedAndTag(status,s, pageable);
    }
    public Page<Publication> findAllByAlbumClosed(boolean status, Pageable pageable) {
        return publicationRepository.findAllByAlbumClosed(status, pageable);
    }

    public  Page<Publication> findImagesBySubscribers(User user, Pageable pageable) {
        return publicationRepository.findImagesBySubscribers(user, pageable);
    }
}
