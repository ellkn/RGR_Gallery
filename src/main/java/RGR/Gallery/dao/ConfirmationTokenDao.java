package RGR.Gallery.dao;

import RGR.Gallery.model.ConfirmationToken;
import RGR.Gallery.model.User;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class ConfirmationTokenDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final UserDao userDao;

    public ConfirmationTokenDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate, UserDao userDao) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.userDao = userDao;
    }

    public void saveConfirmationToken(ConfirmationToken confirmationToken) {
        String stringBuilder = "INSERT INTO confirmationToken(createdAt,expiresAt,token,userId)" +
                " VALUES(:createdAt,:expiresAt,:token,:userId)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("createdAt", confirmationToken.getCreatedAt());
        parameterSource.addValue("expiresAt", confirmationToken.getExpiresAt());
        parameterSource.addValue("token", confirmationToken.getToken());
        parameterSource.addValue("userId", confirmationToken.getUser().getUserId());

            namedParameterJdbcTemplate.update(stringBuilder, parameterSource);
    }

    public Optional<ConfirmationToken> findByToken(String token) {
        String sql = "SELECT * FROM confirmationtoken ct where ct.Token = :token";
        Map<String, Object> params = new HashMap<>();
        params.put("token", token);
        return namedParameterJdbcTemplate.query(sql, params, (ResultSet rs) -> {
            ConfirmationToken confirmationToken = new ConfirmationToken();
            while (rs.next()) {
                confirmationToken.setCreatedAt(rs.getTimestamp("createdAt").toLocalDateTime());
                confirmationToken.setExpiresAt(rs.getTimestamp("expiresAt").toLocalDateTime());
                confirmationToken.setConfirmationTokenId(rs.getLong("confirmationTokenId"));
                User user = new User();
                Long userId = rs.getLong("userId");
                user.setUserId(userId);
                confirmationToken.setUser(user);
            }
            return Optional.of(confirmationToken);//TODO Add user load functionality
        });
    }

    public void updateConfirmedAt(Long tokenId, LocalDateTime confirmedAt) {
        String sql = "UPDATE confirmationtoken ct SET confirmedAt = :confirmedAt where ct.confirmationtokenId = :tokenId";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("tokenId",tokenId);
        parameterSource.addValue("confirmedAt",confirmedAt);
        namedParameterJdbcTemplate.update(sql,parameterSource);

    }
}
