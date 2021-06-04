package RGR.Gallery.service.implementations;

import RGR.Gallery.dao.AlbumDao;
import RGR.Gallery.model.Album;
import RGR.Gallery.service.interfaces.AlbumService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumDao albumDao;

    public AlbumServiceImpl(AlbumDao albumDao) {
        this.albumDao = albumDao;
    }

    public List<Album> loadAlbums(Long userId) {
        return albumDao.loadAlbums(userId);
    }
}
