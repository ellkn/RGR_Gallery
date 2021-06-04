package RGR.Gallery.dao;

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
public class DocumentDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DocumentDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void deleteDocument(Long documentId) {
        String sql = "DELETE FROM document WHERE document.documentId = :documentId";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("documentId",documentId);
        namedParameterJdbcTemplate.update(sql,parameterSource);
    }

    public Document loadDocument(Long documentId) {
        Document document = new Document();

        return document;
    }

    public List<Document> loadDocuments(Long userId) {
        List<Document> documents = new ArrayList<>();
        //TODO
        return documents;
    }

    public Long addDocument(Document document) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO document(userId,title,");
        if (document.getTags() != null) {
            stringBuilder.append(",tags");
            parameterSource.addValue("description", document.getTags());
        }
        stringBuilder.append(") VALUES(:userId,:title");
        if (document.getTags() != null) {
            stringBuilder.append(",:tags");
        }
        stringBuilder.append(")");
        parameterSource.addValue("userId", document.getUser().getUserId());
        parameterSource.addValue("title", document.getTitle());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(stringBuilder.toString(), parameterSource,keyHolder, new String[]{"documentId"});
        Number documentId = keyHolder.getKey();
        return Objects.requireNonNull(documentId).longValue();

    }
}
