package RGR.Gallery.dao;

import RGR.Gallery.model.Album;
import RGR.Gallery.model.Document;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class AlbumDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final DocumentDao documentDao;

    public AlbumDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DocumentDao documentDao) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.documentDao = documentDao;
    }


    public Long addAlbum(Album album) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO album(userId,title");
        if (album.getDescription() != null) {
            stringBuilder.append(",description");
            parameterSource.addValue("description", album.getDescription());
        }
        if (album.getShared() != null) {
            stringBuilder.append(",isShared");
            parameterSource.addValue("isShared", album.getShared());
        }
        stringBuilder.append(") VALUES(:userId,:title");
        if (album.getDescription() != null) {
            stringBuilder.append(",:description");
        }
        if (album.getShared() != null) {
            stringBuilder.append(",:isShared");
        }
        stringBuilder.append(")");
        parameterSource.addValue("userId", album.getUser().getUserId());
        parameterSource.addValue("title", album.getTitle());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(stringBuilder.toString(), parameterSource,keyHolder, new String[]{"albumId"});
        Number albumId = keyHolder.getKey();
        return Objects.requireNonNull(albumId).longValue();
    }

    public List<Album> loadAlbums(Long userId) {
        List<Album> albumList = new ArrayList<>();

        return albumList;
    }
    public Album loadAlbum(Long userId) {
        return new Album();//TODO
    }

    public void updateAlbum(Album album) {
        /*String sql = "UPDATE album u SET u.enabled = 1 WHERE u.UserId = :userId";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("userId",userId);
        namedParameterJdbcTemplate.update(sql,parameterSource);*/
    }

    public void removeAlbum(Album album) {
        for (Document document : album.getDocuments()) {
            documentDao.deleteDocument(document.getDocumentId());
        }
        String sql = "DELETE FROM album WHERE album.albumId = :albumId";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("albumId",album.getAlbumId());
        namedParameterJdbcTemplate.update(sql,parameterSource);
    }

}
