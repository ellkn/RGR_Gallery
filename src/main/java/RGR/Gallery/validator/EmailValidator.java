package RGR.Gallery.validator;

import RGR.Gallery.dao.UserDao;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmailValidator {

    private final UserDao userDao;

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public EmailValidator(UserDao userDao) {
        this.userDao = userDao;
    }

    public String validate(String email) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        if (!matcher.find()) {
            return "Email format is invalid.";
        }
        return checkIsEmailExists(email);
    }

    private String checkIsEmailExists(String email) {
        if (userDao.checkIsEmailExists(email)){
            return "Email already exists";
        }
        return null;
    }
}
