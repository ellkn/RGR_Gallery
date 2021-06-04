package RGR.Gallery.dao;

import RGR.Gallery.model.Comment;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class CommentDao {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public CommentDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate){
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public Comment loadComment(Long commentId) {
        Comment comment = new Comment();

        return comment;
    }

    public List<Comment> loadComments(Long publicationId) {
        List<Comment> commentList = new ArrayList<>();

        return commentList;
    }

    public Long addComment(Comment comment) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO comment(publicationId,comment, createdBy");
        if (comment.getDocument() != null) {
            stringBuilder.append(",document");
            parameterSource.addValue("comment", comment.getDocument());
        }
        stringBuilder.append(") VALUES(:userId,:title,:createdBy");
        if (comment.getDocument() != null) {
            stringBuilder.append(",:document");
        }

        stringBuilder.append(")");
        parameterSource.addValue("publicationId", comment.getPublication().getPublicationId());
        parameterSource.addValue("comment", comment.getComment());
        parameterSource.addValue("createdBy", comment.getCreatedBy().getUserId());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(stringBuilder.toString(), parameterSource, keyHolder, new String[]{"commentId"});
        Number commentId = keyHolder.getKey();
        return Objects.requireNonNull(commentId).longValue();

    }

    public void updateComment(Comment comment) {

    }

    public void deleteComment(Long commentId){
        String sql = "DELETE FROM comment WHERE comment.commentId = :commentId";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("commentId",commentId);
        namedParameterJdbcTemplate.update(sql,parameterSource);
    }
}
