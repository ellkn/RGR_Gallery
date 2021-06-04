package RGR.Gallery.dao;

import RGR.Gallery.model.Comment;
import RGR.Gallery.model.Publication;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class PublicationDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final CommentDao commentDao;
    private final DocumentDao documentDao;

    public PublicationDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate, CommentDao commentDao, DocumentDao documentDao) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.commentDao = commentDao;
        this.documentDao = documentDao;
    }
    public Publication loadPublication(Long publicationId) {
        Publication publication = new Publication();

        return publication;
    }
    public List<Publication> loadPublications(Long userId) {
        List<Publication> publications = new ArrayList<>();

        return publications;
    }
    public Long addPublication(Publication publication) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("INSERT INTO comment(publicationId,comment, createdBy");
        KeyHolder keyHolder = new GeneratedKeyHolder();
//        namedParameterJdbcTemplate.update(sql, parameterSource,keyHolder, new String[]{"publicationId"});
        Number publicationId = keyHolder.getKey();
        return Objects.requireNonNull(publicationId).longValue();

    }
    public void removePublication(Publication publication){
        for (Comment comment : publication.getComments()) {
            commentDao.deleteComment(comment.getCommentId());
        }
        String sql = "DELETE FROM pubication WHERE publication.publicationId = :publicationId";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("publicationId", publication.getPublicationId());
        namedParameterJdbcTemplate.update(sql,parameterSource);

    }
}
