package RGR.Gallery.repository;

import RGR.Gallery.domain.Album;
import RGR.Gallery.domain.Publication;
import RGR.Gallery.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublicationRepository extends JpaRepository<Publication, Long> {
    List<Publication> findByTag(String tag);
    Page<Publication> findByAlbumClosedAndTag(boolean status, String tag, Pageable pageable);
    Page<Publication> findAllByAlbumClosed(boolean status, Pageable pageable);
    Page<Publication> findImagesByAlbum(Album album, Pageable pageable);
    Page<Publication> findImagesBySubscribers(User user, Pageable pageable);

}
