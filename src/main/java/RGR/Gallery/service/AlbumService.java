package RGR.Gallery.service;

import RGR.Gallery.domain.Album;
import RGR.Gallery.domain.User;
import RGR.Gallery.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AlbumService {
    @Autowired
    AlbumRepository albumRepository;

    public void save(Album album) {
        albumRepository.save(album);
    }

    public Set<Album> findAlbumsByClosedAndAuthor(boolean status, User user) {
        return albumRepository.findAlbumsByClosedAndAuthor(status,user);
    }

    public Set<Album> findAlbumsByAuthor( User user) {
        return albumRepository.findAlbumsByAuthor(user);
    }

    public Long countAlbums(User user) {
        return albumRepository.countAlbumsByAuthor(user);
    }

    public void delete(Album album) {
        albumRepository.delete(album);
    }

}
