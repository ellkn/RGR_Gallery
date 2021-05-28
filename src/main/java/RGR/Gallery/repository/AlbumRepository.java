package RGR.Gallery.repository;

import RGR.Gallery.domain.Album;
import RGR.Gallery.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    Set<Album> findAlbumsByClosedAndAuthor(boolean status, User user);
    Set<Album> findAlbumsByAuthor(User user);
    Long countAlbumsByAuthor(User user);
}
