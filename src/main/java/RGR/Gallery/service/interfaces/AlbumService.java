package RGR.Gallery.service.interfaces;

import RGR.Gallery.model.Album;

import java.util.List;

public interface AlbumService {
    List<Album> loadAlbums(Long userId);
}
