package RGR.Gallery.dao;

import RGR.Gallery.model.User;
import RGR.Gallery.utils.DateUtil;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Component
public class UserDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public UserDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public Long addUser(User user) {
        String sql = "INSERT INTO user(firstName,lastName,email,password,dateOfBirth,city,enabled,name) " +
                "VALUES(:firstName,:lastName,:email,:password,:dateOfBirth,:city,:enabled,:name)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
            parameterSource.addValue("firstName", user.getFirstName());
             parameterSource.addValue("lastName", user.getLastName());
             parameterSource.addValue("email", user.getEmail());
             parameterSource.addValue("password", user.getPassword());
             parameterSource.addValue("dateOfBirth", user.getDateOfBirth());
             parameterSource.addValue("city", user.getCity());
             parameterSource.addValue("enabled", 0);
             parameterSource.addValue("name", user.getFirstName() + " " + user.getLastName());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, parameterSource,keyHolder, new String[]{"userId"});
        Number userId = keyHolder.getKey();
        return Objects.requireNonNull(userId).longValue();
    }

    public List<User> loadUsers(String name) {
        String sql = "SELECT * FROM user where user.name LIKE '%:name%'";
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        return namedParameterJdbcTemplate.query(sql, params, (ResultSet rs) -> {
            List<User> users = new ArrayList<>();
            while (rs.next()) {
                User user = new User();
                collectUserDataFromRS(rs,user);
                users.add(user);
            }
            return users;
        });
    }

    public User loadUser(Long userId) {
        String sql = "SELECT * FROM user where user.UserId = :userId";
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        return namedParameterJdbcTemplate.query(sql, params, (ResultSet rs) -> {
            if (rs.next()) {
                User user = new User();
                collectUserDataFromRS(rs,user);
                return user;
            }
            return null;
        });
    }

    public void confirmAccount(Long userId) {
        String sql = "UPDATE user u SET u.enabled = 1 WHERE u.UserId = :userId";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("userId",userId);
        namedParameterJdbcTemplate.update(sql,parameterSource);
    }

    public boolean checkIsEmailExists(String email) {
        User user = loadUserByEmail(email);
        return user != null && user.getEmail() != null;
    }

    public User loadUserByEmail(String email) {
        String sql = "SELECT * FROM user where user.email = :email";
        Map<String, Object> params = new HashMap<>();
        params.put("email", email);
        return namedParameterJdbcTemplate.query(sql, params, (ResultSet rs) -> {
            User user;
            while (rs.next()) {
                user = new User();
                collectUserDataFromRS(rs,user);
                return user;
            }
            return null;
        });
    }


    private void collectUserDataFromRS(ResultSet resultSet,User user) throws SQLException {
        user.setUserId(resultSet.getLong("userId"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        user.setFirstName(resultSet.getString("firstName"));
        user.setLastName(resultSet.getString("lastName"));
        user.setEnabled(resultSet.getBoolean("enabled"));
        if (resultSet.getString("city") != null) {
            user.setCity(resultSet.getString("city"));
        }
        user.setDateOfBirth(DateUtil.convertToLocalDateViaInstant(resultSet.getDate("dateOfBirth")));
    }


}
