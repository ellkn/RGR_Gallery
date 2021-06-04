package RGR.Gallery.dao;

import RGR.Gallery.model.User;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final UserDao userDao;

    public AuthenticationDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate, UserDao userDao) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.userDao = userDao;
    }

    public User loadUserInfo(String email) {
        return userDao.loadUserByEmail(email);
    }

}
